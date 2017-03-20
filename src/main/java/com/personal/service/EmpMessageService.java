package com.personal.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageBean.PageBean;
import com.personal.dao.EmpMessageDao;
import com.personal.model.EmpMessage;

@Service
public class EmpMessageService {
	@Autowired
	private EmpMessageDao empMessageDao;
	
	public void addEmpMessage(EmpMessage empMessage) throws Exception {
		empMessageDao.addEmpMessage(empMessage);
		
	}
	
	public EmpMessage queryEmpMessage(int empId) throws Exception {	
		EmpMessage empMessage = empMessageDao.queryEmpMessage(empId);
		return empMessage;
	}
	
	public void addupMessage (EmpMessage empMessage) throws SQLException {
		empMessageDao.addupMessage(empMessage);
	}
	
	public List<EmpMessage> queryAllContacts () throws SQLException {
		List<EmpMessage> list = empMessageDao.queryAllContacts();
		return list;
	} 
	
	public PageBean<EmpMessage> queryContacts(int pc, int ps ) throws SQLException {
		PageBean<EmpMessage> pageBean = empMessageDao.queryContacts(pc, ps);
		return pageBean;
	}	
}