package com.root.resc.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageBean.PageBean;
import com.root.resc.dao.RescDao;
import com.root.resc.model.Resources;

@Service
public class RescService {
	@Autowired 
	private RescDao rescDao;
	
	public List<Resources> queryRescById(int userId) {
		List<Resources> rescs = rescDao.queryRescById(userId);
		return rescs;
	}
	
	public PageBean<Resources> queryRescList(int pc ,int ps) throws SQLException {
		PageBean<Resources> pageBean = rescDao.queryRescList(pc,ps);
		return pageBean;
	}
	
	public void addResc(Resources resc) throws SQLException {
		rescDao.addResc(resc);
	}
	
	public void updateResc(Resources resc) throws SQLException {
		rescDao.updateResc(resc);
	}
	
	public void deleteResc(int rescId) throws SQLException {
		rescDao.deleteResc(rescId);
	}	
	public Resources queryByRescId(int rescId) throws SQLException {
		Resources resc = rescDao.queryByRescId(rescId);
		return resc;
	}
}
