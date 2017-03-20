package com.root.user.model;

public class UserLoginList {

	private int loginId;
	private String userName;
	private String loginTime;
	private String loginIp;

	public UserLoginList() {

	}

	public UserLoginList(int loginId, int userId, String userName,
			String loginTime, String loginIp) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	
}
