package com.commu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.commu.model.Comm;
import com.pageBean.PageBean;

@Component
public class CmDao extends BaseDao{
	public void addComm(Comm comm) throws SQLException{
		sqlMapClient.insert("addComm",comm);
	}
	
	public int cmcount(int mesId) throws SQLException{
		int cmcount = (Integer)sqlMapClient.queryForObject("cmcount",mesId);
		return cmcount;
	}
	
	public PageBean<Comm> cmlist(int pc ,int ps, int mesId) throws SQLException{
		PageBean<Comm> pageBean = new PageBean<Comm>();
		HashMap<String , Object> hashMap = new HashMap<String , Object>();
		pageBean.setPs(ps);
		int tr = (Integer)sqlMapClient.queryForObject("cmcount",mesId);
		pageBean.setTr(tr);
		int tp = pageBean.getTp();
		if(pc < 1 ) {pc = 1; }
		if(pc > tp ) {pc = tp; }
		pageBean.setPc(pc);
		int beginNumber = pageBean.getBeginNumber();
		int endNumber = pageBean.getEndNumber();
		hashMap.put("beginNumber", beginNumber);
		hashMap.put("endNumber", endNumber);
		hashMap.put("mesId", mesId);
		@SuppressWarnings("unchecked")
		List<Comm> beanList = sqlMapClient.queryForList("cmlist",hashMap);
		pageBean.setBeanList(beanList);
		return pageBean;
	}
}
