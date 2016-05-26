package com.bcdbook.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bcdbook.user.dao.UserDao;
import com.bcdbook.user.pojo.User;
import com.bcdbook.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		return this.userDao.selectById(userId);
	}

}
