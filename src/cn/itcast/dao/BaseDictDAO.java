package cn.itcast.dao;

import java.util.List;
import cn.itcast.domain.BaseDict;

public interface BaseDictDAO extends BaseDAO<BaseDict> {

	public List<BaseDict> findByTypeCode(String dict_type_code);

}
