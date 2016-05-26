package com.bcdbook.user.service;

import java.util.List;

import com.bcdbook.user.pojo.User;

public interface UserService {
	public User getUserById(int userId);
	public void addUsers(List<User> users);
}
