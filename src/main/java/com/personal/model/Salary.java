package com.personal.model;

public class Salary {
	private int empId;
	private int mon;
	private float basic;
	private int overtime;
	private int leavertime;
	private float comn;
	private float punish;
	private float safest;
	private float scot;
	private String granttime;

	public Salary() {
	}

	public Salary(int empId, int mon, float basic, int overtime,
			int leavertime, float comn, float punish, float safest, float scot,
			String granttime) {
		this.empId = empId;
		this.mon = mon;
		this.basic = basic;
		this.overtime = overtime;
		this.leavertime = leavertime;
		this.comn = comn;
		this.punish = punish;
		this.safest = safest;
		this.scot = scot;
		this.granttime = granttime;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getMon() {
		return mon;
	}

	public void setMon(int mon) {
		this.mon = mon;
	}

	public float getBasic() {
		return basic;
	}

	public void setBasic(float basic) {
		this.basic = basic;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public int getLeavertime() {
		return leavertime;
	}

	public void setLeavertime(int leavertime) {
		this.leavertime = leavertime;
	}

	public float getComn() {
		return comn;
	}

	public void setComn(float comn) {
		this.comn = comn;
	}

	public float getPunish() {
		return punish;
	}

	public void setPunish(float punish) {
		this.punish = punish;
	}

	public float getSafest() {
		return safest;
	}

	public void setSafest(float safest) {
		this.safest = safest;
	}

	public float getScot() {
		return scot;
	}

	public void setScot(float scot) {
		this.scot = scot;
	}

	public String getGranttime() {
		return granttime;
	}

	public void setGranttime(String granttime) {
		this.granttime = granttime;
	}

}
