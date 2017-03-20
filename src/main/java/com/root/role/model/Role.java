package com.root.role.model;

import java.util.HashSet;
import java.util.Set;

import com.root.resc.model.Resources;

public class Role {

	private Integer roleId;
	private Integer enable;//是否禁用角色　1　表示禁用　2　表示不禁用
	private String roleName;
	private String roleKey;
	private String description;
	private Set<Resources> resources = new HashSet<Resources>(0);
	
	public Role() {
		
	}
	
	public Role(Integer roleId, Integer enable, String roleName,
			String roleKey, String description, Set<Resources> resources) {
		super();
		this.roleId = roleId;
		this.enable = enable;
		this.roleName = roleName;
		this.roleKey = roleKey;
		this.description = description;
		this.resources = resources;
	}



	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getRoleKey() {
		return roleKey;
	}
	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Resources> getResources() {
		return resources;
	}
	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}
	
	
}
