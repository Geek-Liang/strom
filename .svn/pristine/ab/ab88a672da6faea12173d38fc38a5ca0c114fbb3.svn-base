package com.bcdbook.menu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bcdbook.menu.dao.MenuDao;
import com.bcdbook.menu.pojo.Menu;
import com.bcdbook.menu.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuDao menuDao;
	
	@Override
	public String addMenu(Menu menu) {
		menuDao.insert(menu);
		// TODO Auto-generated method stub
		return null;
	}
}
