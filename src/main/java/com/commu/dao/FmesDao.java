package com.commu.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.commu.model.Fmes;
import com.pageBean.PageBean;

@Component
public class FmesDao extends BaseDao{
	
	public void fatie(Fmes fmes) throws SQLException {
		sqlMapClient.insert("fatie",fmes);
	}
	
	public Fmes queryById (int mesId) throws SQLException {
		Fmes fmes = (Fmes)sqlMapClient.queryForObject("queryById",mesId);
		return fmes;
	}
	
	public void updatepraise(int mesId,int praise)  throws SQLException{
		HashMap<String , Integer> hashMap = new HashMap<String , Integer>();
		hashMap.put("mesId", mesId);
		hashMap.put("praise", praise);
		sqlMapClient.update("updatepraise", hashMap);
	}
	
	public PageBean<Fmes> flist(int pc, int ps) throws SQLException {
		int tr = (Integer)sqlMapClient.queryForObject("fcount");
		PageBean<Fmes> pageBean = new PageBean<Fmes>();
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		int tp = pageBean.getTp();
		if (pc < 1) {pc = 1; }
		if (pc > tp) {pc = tp; }
		pageBean.setPc(pc);
		@SuppressWarnings("unchecked")
		List<Fmes> beanList = sqlMapClient.queryForList("flist", pageBean);
		pageBean.setBeanList(beanList);
		return pageBean;
	}
}
