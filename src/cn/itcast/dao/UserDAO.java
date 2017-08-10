package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDAO extends BaseDAO<User> {

	public User findByCodeAndPassword(String user_code, String user_password);

}
