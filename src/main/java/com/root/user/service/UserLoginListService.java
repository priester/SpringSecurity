package com.root.user.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageBean.PageBean;
import com.root.user.dao.UserLoginListDao;
import com.root.user.model.UserLoginList;

@Service
public class UserLoginListService {
	@Autowired
	private UserLoginListDao userLoginListDao;
	
	public void addLoginList(UserLoginList userLoginList) {
		userLoginListDao.addLoginList(userLoginList);
	}
	
	public PageBean<UserLoginList> queryAlllog (int pc ,int ps) throws SQLException{
		PageBean<UserLoginList> pageBean= userLoginListDao.queryAlllog(pc, ps);
		return pageBean;
	}
	
}
