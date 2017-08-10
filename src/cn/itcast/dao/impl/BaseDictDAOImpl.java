package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.dao.BaseDictDAO;
import cn.itcast.domain.BaseDict;

public class BaseDictDAOImpl extends BaseDAOImpl<BaseDict> implements BaseDictDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BaseDict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		return (List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
	}

}
