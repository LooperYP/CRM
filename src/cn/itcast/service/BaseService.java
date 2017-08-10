package cn.itcast.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
	
	public void save(T t);

	public void delete(T t);
	
	public void update(T t);
	
	public T findById(Class<T> clazz, Serializable id);
	
	public List<T> findAll(Class<T> clazz);

}
