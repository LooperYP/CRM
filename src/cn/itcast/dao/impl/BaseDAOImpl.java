package cn.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import cn.itcast.dao.BaseDAO;

@SuppressWarnings("unchecked")
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {

//	private Class clazz;
//
//	public BaseDAOImpl() {
//		clazz = this.getClass();
//		//System.out.println(clazz);
//		Type type = clazz.getGenericSuperclass();
//		//System.out.println(type);
//		
//		if (type instanceof ParameterizedType) {
//			ParameterizedType ptype = (ParameterizedType) type;
//			Type[] actualTypeArguments = ptype.getActualTypeArguments();
//			
//			this.clazz = (Class) actualTypeArguments[0];
//		}
//		//System.out.println(clazz);
//	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T findById(Class<T> clazz, Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<T> findAll(Class<T> clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	
	@Override
	public long findCountByCriteria(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty()?0:list.get(0);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return (List<T>) getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		criteria.setProjection(null);
		return (List<T>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}
	
}
