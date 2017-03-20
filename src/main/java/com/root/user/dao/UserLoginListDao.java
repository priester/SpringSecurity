package com.root.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.pageBean.PageBean;
import com.root.user.model.UserLoginList;

@Component
public class UserLoginListDao extends BaseDao{

	public void addLoginList(UserLoginList userLoginList)  {
		try {
			sqlMapClient.insert("addLoginList", userLoginList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public PageBean<UserLoginList> queryAlllog(int pc ,int ps) throws SQLException {
		PageBean<UserLoginList> pageBean = new PageBean<UserLoginList>();
		int tr = (Integer)sqlMapClient.queryForObject("logCount");
		pageBean.setTr(tr);
		pageBean.setPs(ps);
		int tp = pageBean.getTp();
		if ( pc < 1 ) { pc = 1; } 
		if ( pc > tp ) { pc = tp; }
		pageBean.setPc(pc);
		@SuppressWarnings("unchecked")
		List<UserLoginList> beanList = sqlMapClient.queryForList("queryAlllog", pageBean);
		pageBean.setBeanList(beanList);
		return pageBean;
	}
}
