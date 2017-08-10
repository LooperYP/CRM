package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.User;

public interface UserService {

	public User findUser(User user);

	public List<User> findAll(Class<User> clazz);

}
