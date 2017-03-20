package com.root.role.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageBean.PageBean;
import com.root.role.dao.RoleDao;
import com.root.role.model.Role;

@Service
public class RoleService {
	@Autowired 
	private RoleDao roleDao;
	
	public void addRole(Role role) throws SQLException {
		roleDao.addRole(role);
	}
	
	public void deleteRole(int roleId) throws SQLException{
		roleDao.deleteRole(roleId);
	}
	
	public void updateRole(Role role) throws SQLException{
		roleDao.updateRole(role);
	}
	
	public Role queryRoleById(int roleId) throws SQLException {
		Role role = roleDao.queryRoleById(roleId);
		return role;
	}
	
	public PageBean<Role> queryAll(int pc ,int ps) throws SQLException{
		PageBean<Role> pageBean = roleDao.queryAll(pc, ps);
		return pageBean;
	}
}
