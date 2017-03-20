package com.root.user.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.pageBean.PageBean;
import com.root.user.model.User;

@Component
public class UserDao extends BaseDao {
	
	public void addUser(User user) throws SQLException{
		System.out.println(user.getUserName());
		sqlMapClient.insert("addUser", user);
	}
	
	public void updateua(HashMap<String,Integer> map) throws SQLException{
		sqlMapClient.update("updateUserua", map);
	}
	
	public User queryUser(String userName) {
		User user = null;

		try {
			user = (User) sqlMapClient.queryForObject("queryUser", userName);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	
	
	public void updateUserpw(User user) throws SQLException{
		sqlMapClient.update("updateUserpw", user);
	}
	
	public PageBean<User> queryUserList(int pc, int ps) throws SQLException{
		PageBean<User> pageBean = new PageBean<User>();
			if (pc < 1) {
				pc = 1;
			}
			pageBean.setPs(ps);
			
			int tr = (Integer) sqlMapClient.queryForObject("selectCount");
			System.out.println("tr"+tr);
			pageBean.setTr(tr);
			int tp = pageBean.getTp();
			if (pc > tp) {
				pc = tp;
			}
			
			pageBean.setPc(pc);
			@SuppressWarnings("unchecked")
			List<User> beanList = sqlMapClient.queryForList("queryUserList",
					pageBean);
			pageBean.setBeanList(beanList);
		return pageBean;
	}

}
