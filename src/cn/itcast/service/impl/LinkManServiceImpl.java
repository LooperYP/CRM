package cn.itcast.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import cn.itcast.dao.LinkManDAO;
import cn.itcast.domain.LinkMan;
import cn.itcast.page.Pagination;
import cn.itcast.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {
	private LinkManDAO linkManDAO;

	public void setLinkManDAO(LinkManDAO linkManDAO) {
		this.linkManDAO = linkManDAO;
	}

	@Override
	public void saveLinkMan(LinkMan linkMan) {
		linkManDAO.save(linkMan);
	}

	@Override
	public void findLinkManPageList(Pagination<LinkMan> pagination) {
		//条件
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		
		String lkm_name = parameterMap.get("lkm_name")==null?null:parameterMap.get("lkm_name")[0];
		String lkm_gender = parameterMap.get("lkm_gender")==null?null:parameterMap.get("lkm_gender")[0];
		if (StringUtils.isNotBlank(lkm_name)) {
			criteria.add(Restrictions.like("lkm_name", lkm_name, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(lkm_gender)) {
			criteria.add(Restrictions.eq("lkm_gender", lkm_gender));
		}
		
		//封装参数
		Long totalCount = linkManDAO.findCountByCriteria(criteria);
		pagination.setTotalCount(totalCount);
		
		List<LinkMan> resultList = linkManDAO.findByCriteria(criteria,pagination.getFirstResult(),pagination.getMaxResults());
		pagination.setResultList(resultList);
	}

	@Override
	public LinkMan findLinkManById(Long id) {
		return linkManDAO.findById(LinkMan.class, id);
	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		linkManDAO.update(linkMan);
	}

	@Override
	public void deleteLinkMan(LinkMan linkMan) {
		linkManDAO.delete(linkMan);
	}
	
	
}
