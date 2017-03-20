package com.root.role.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.pageBean.PageBean;
import com.root.role.model.Role;

@Component
public class RoleDao extends BaseDao {

	public void addRole(Role role) throws SQLException {
		sqlMapClient.insert("insertRole", role);
	}

	public void deleteRole(int roleId) throws SQLException {
		sqlMapClient.delete("deleteRole", roleId);
	}

	public void updateRole(Role role) throws SQLException {
		sqlMapClient.update("updateRole", role);
	}
	
	public Role queryRoleById(int roleId) throws SQLException {
		Role role = (Role)sqlMapClient.queryForObject("queryRoleById", roleId);
		return role;
	}
	
	public PageBean<Role> queryAll(int pc, int ps) throws SQLException {
		if (pc < 1) {
			pc = 1;
		}
		int tr = (Integer) sqlMapClient.queryForObject("roleCount");
		System.out.println("tr"+tr);
		PageBean<Role> pageBean = new PageBean<Role>();
		pageBean.setPs(ps);
		pageBean.setTr(tr);
		int tp = pageBean.getTp();
		if (pc > tp) {
			pc = tp;
		}
		pageBean.setPc(pc);
		@SuppressWarnings("unchecked")
		List<Role> beanList = sqlMapClient.queryForList("queryAllRole", pageBean);

		pageBean.setBeanList(beanList);
		return pageBean;
	}
}
