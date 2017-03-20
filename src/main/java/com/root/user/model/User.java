package com.root.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private int userId;
	private String name;
	private String userName;
	private String roleName;
	private String password;
	private String crDate;// 账号创建日期
	private String roleId;
	
	public User() {
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(int userId, String name, String userName, String roleName,
			String password, String crDate, String roleId) {
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.roleName = roleName;
		this.password = password;
		this.crDate = crDate;
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCrDate() {
		return crDate;
	}

	public void setCrDate(String crDate) {
		this.crDate = crDate;
	}

	public void setCrDate() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		this.crDate = sdFormatter.format(nowTime);
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
