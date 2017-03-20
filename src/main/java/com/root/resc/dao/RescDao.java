package com.root.resc.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.pageBean.PageBean;
import com.root.resc.model.Resources;
@Component
public class RescDao extends BaseDao{
	
	@SuppressWarnings("unchecked")
	public List<Resources> queryRescById(int userId) {
		List<Resources> resc = null;
		
		try {
			
			resc = sqlMapClient.queryForList("qureyRescById",userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RescDao查出的"+resc);
		
		for (Resources res : resc) {
			// TODO:ZZQ 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
			// 关联代码：applicationContext-security.xml
			// 关联代码：com.huaxin.security.MySecurityMetadataSource#loadResourceDefine

			System.out.println("RecsDao获取用户ResKey"+res.getRescKey());
			System.out.println("RecsDao获取用户ResKey"+res.getRescName());
		}
		return resc;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> qureySById(int userId){
		List<String> rescKeys = null;
		try {
			rescKeys = sqlMapClient.queryForList("qureySById", userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rescKeys;
	}
	
	@SuppressWarnings("unchecked")
	public List<Resources> qureAll() {
		List<Resources> rescs = null;
		try {
			rescs = sqlMapClient.queryForList("queryAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rescs;
	} 
	@SuppressWarnings("unchecked")
	public PageBean<Resources> queryRescList(int pc ,int ps)
			throws SQLException {
		PageBean<Resources> pageBean = new PageBean<Resources>();
		int tr = (Integer)sqlMapClient.queryForObject("selectCountr");
		if (pc < 1){
			pc=1;
		}
		pageBean.setTr(tr);
		pageBean.setPs(ps);
		int tp = pageBean.getTp();
		if (pc>tp) {
			pc = tp ;
		}
		pageBean.setPc(pc);
		List<Resources> beanList = 
				sqlMapClient.queryForList("queryRescList", pageBean);
		pageBean.setBeanList(beanList);
		return pageBean;
	}
	
	public void addResc(Resources resc) throws SQLException{
		sqlMapClient.insert("insertResc", resc);
	}
	public void updateResc(Resources resc) throws SQLException{
		sqlMapClient.update("updateResc", resc);
	}
	public void deleteResc(int rescId) throws SQLException{
		sqlMapClient.delete("deleteResc", rescId);
	}
	public Resources queryByRescId(int rescId) throws SQLException{
		Resources resc= (Resources)sqlMapClient.queryForObject("queryByRescId", rescId);
		return resc;
	}
}
