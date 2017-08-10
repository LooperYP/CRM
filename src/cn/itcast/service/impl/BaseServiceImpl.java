package cn.itcast.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.dao.BaseDAO;
import cn.itcast.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	
	private BaseDAO<T> baseDAO;
	@Autowired
	public void setBaseDAO(BaseDAO<T> baseDAO) {
		this.baseDAO = baseDAO;
	}
	
	@Override
	public void save(T t) {
		baseDAO.save(t);
	}

	@Override
	public void delete(T t) {
		baseDAO.delete(t);
	}

	@Override
	public void update(T t) {
		baseDAO.update(t);
	}

	@Override
	public T findById(Class<T> clazz,Serializable id) {
		return baseDAO.findById(clazz,id);
	}

	@Override
	public List<T> findAll(Class<T> clazz) {
		return baseDAO.findAll(clazz);
	}

}
