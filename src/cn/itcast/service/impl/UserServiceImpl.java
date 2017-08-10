package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.UserDAO;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findUser(User user) {
		return userDAO.findByCodeAndPassword(user.getUser_code(),user.getUser_password());
	}

	@Override
	public List<User> findAll(Class<User> clazz) {
		return userDAO.findAll(clazz);
	}

}
