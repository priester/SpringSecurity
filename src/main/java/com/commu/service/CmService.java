package com.commu.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commu.dao.CmDao;
import com.commu.model.Comm;
import com.pageBean.PageBean;

@Service
public class CmService {
	@Autowired
	private CmDao cmdao;

	public void addComm(Comm comm) throws SQLException {
		cmdao.addComm(comm);
	}

	public int cmcount(int mesId) throws SQLException {
		int count = cmdao.cmcount(mesId);
		return count;
	}

	public PageBean<Comm> cmlist(int pc, int ps, int mesId) throws SQLException {
		PageBean<Comm> pageBean = cmdao.cmlist(pc, ps, mesId);
		return pageBean;
	}
}
