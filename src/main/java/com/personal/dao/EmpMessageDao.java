package com.personal.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.pageBean.PageBean;
import com.personal.model.EmpMessage;

@Component
public class EmpMessageDao extends BaseDao {
	public void addEmpMessage(EmpMessage empMessage) throws Exception {
		System.out.print("empMessage");
		sqlMapClient.insert("insertEmpMessage",empMessage);
	}
	
	public EmpMessage queryEmpMessage(int empId) throws Exception {
		EmpMessage empMessage = (EmpMessage)sqlMapClient.queryForObject("qureryEmpMessage",empId);
		return empMessage;
	}
	public void addupMessage(EmpMessage empMessage) throws SQLException{
		sqlMapClient.update("addupMessage", empMessage);
	}
	
	public List<EmpMessage> queryAllContacts() throws SQLException{
		@SuppressWarnings("unchecked")
		List<EmpMessage> list = sqlMapClient.queryForList("queryAllContacts");
		return list;
	}

	public PageBean<EmpMessage> queryContacts(int pc,int ps) throws SQLException {
		PageBean<EmpMessage> pageBean = new PageBean<EmpMessage>();
		int tr = (Integer)sqlMapClient.queryForObject("empCount");
		pageBean.setTr(tr);
		pageBean.setPs(ps);
		int tp = pageBean.getTp();
		if (pc < 1 ) { pc = 1; }
		if (pc > tp ){pc = tp; }
		pageBean.setPc(pc);
		@SuppressWarnings("unchecked")
		List<EmpMessage> beanList = sqlMapClient.queryForList("queryContacts", pageBean);
		pageBean.setBeanList(beanList);
		return pageBean;
	}
}
