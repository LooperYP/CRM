package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDAO<T> {
	
	public void save(T t);

	public void delete(T t);

	public void update(T t);

	public T findById(Class<T> clazz, Serializable id);

	public List<T> findAll(Class<T> clazz);
	
	public long findCountByCriteria(DetachedCriteria criteria);

	public List<T> findByCriteria(DetachedCriteria criteria);
	
	public List<T> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

}