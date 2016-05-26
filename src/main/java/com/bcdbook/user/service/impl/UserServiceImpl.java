package com.bcdbook.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional
	@Override
	public void addUsers(List<User> users) {
		for (int i = 0; i < users.size(); i++) {
			userDao.insert(users.get(i));
//			if(i>2){
//				throw new RuntimeException();
//			}else{
//				userDao.insert(users.get(i));
//			}
		}
	}

}
