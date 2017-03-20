package com.root.user.service;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageBean.PageBean;
import com.root.user.dao.UserDao;
import com.root.user.model.User;

@Service
public class UserService {
	@Autowired 
	private UserDao userDao;
	
	public void addUser(User user)throws SQLException {
	userDao.addUser(user);	
	} 
	
	public void updateua(HashMap<String,Integer> map) throws SQLException{
		userDao.updateua(map);
	}
	
	public void updateUserpw (User user) throws SQLException {
		userDao.updateUserpw(user);
	}
	
	public User queryUser(String userName) {
		User user= userDao.queryUser(userName);
		return user;
	}
	
	public PageBean<User> queryUserList(int pc,int ps) throws SQLException{
		PageBean<User> users = userDao.queryUserList(pc,ps);
		return users;
	}
}
