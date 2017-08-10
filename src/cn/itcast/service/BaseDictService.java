package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.BaseDict;

public interface BaseDictService {

	public List<BaseDict> findBaseDictByTypeCode(String dict_type_code);

}
