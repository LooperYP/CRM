package cn.itcast.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.dao.SaleVisitDAO;
import cn.itcast.domain.SaleVisit;
import cn.itcast.page.Pagination;
import cn.itcast.service.SaleVisitService;

public class SaleVisitServiceImpl implements SaleVisitService {
	private SaleVisitDAO saleVisitDAO;
	
	public void setSaleVisitDAO(SaleVisitDAO saleVisitDAO) {
		this.saleVisitDAO = saleVisitDAO;
	}

	@Override
	public void findSaleVisitPageList(Pagination<SaleVisit> pagination) {
		//条件
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleVisit.class);
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String visit_begin_time = parameterMap.get("visit_begin_time")==null?null:parameterMap.get("visit_begin_time")[0];
		String visit_end_time = parameterMap.get("visit_end_time")==null?null:parameterMap.get("visit_end_time")[0];
		try {
			if (StringUtils.isNotBlank(visit_begin_time)) {
				criteria.add(Restrictions.ge("visit_time", df.parse(visit_begin_time)));
			}
			if (StringUtils.isNotBlank(visit_end_time)) {
				criteria.add(Restrictions.le("visit_time", df.parse(visit_end_time)));
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//封装参数
		Long totalCount = saleVisitDAO.findCountByCriteria(criteria);
		pagination.setTotalCount(totalCount);
		
		List<SaleVisit> resultList = saleVisitDAO.findByCriteria(criteria,pagination.getFirstResult(),pagination.getMaxResults());
		pagination.setResultList(resultList);
	}

	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDAO.save(saleVisit);
	}
	
}
