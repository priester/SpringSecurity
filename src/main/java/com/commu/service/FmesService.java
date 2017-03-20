package com.commu.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commu.dao.FmesDao;
import com.commu.model.Fmes;
import com.pageBean.PageBean;

@Service
public class FmesService {
	@Autowired 
	private FmesDao fmesDao;
	
	
	public void fatie (Fmes fmes)throws SQLException{
		fmesDao.fatie(fmes);
	}
	
	public Fmes queryById (int mesId) throws SQLException {
		Fmes fmes = fmesDao.queryById(mesId);
		return fmes;
	}
	
	public PageBean<Fmes> flist(int pc ,int ps) throws SQLException {
		PageBean<Fmes> pageBean = fmesDao.flist(pc, ps);
		return pageBean;
	}
	
	public void updatepraise(int empId,int praise)  throws SQLException{
		fmesDao.updatepraise(empId, praise);
	}
}
