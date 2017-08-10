package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.BaseDictDAO;
import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDAO baseDictDAO;

	public void setBaseDictDAO(BaseDictDAO baseDictDAO) {
		this.baseDictDAO = baseDictDAO;
	}

	@Override
	public List<BaseDict> findBaseDictByTypeCode(String dict_type_code) {
		return baseDictDAO.findByTypeCode(dict_type_code);
	}

}
