package com.personal.model;

import java.sql.Date;

public class WorkTime {
	private int empId;
	private int name;
	private Date datetime;
	private String wktime;
	private String offtime;

	public WorkTime() {
	}

	public WorkTime(int empId, int name, Date datetime, String wktime,
			String offtime) {
		this.empId = empId;
		this.name = name;
		this.datetime = datetime;
		this.wktime = wktime;
		this.offtime = offtime;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getWktime() {
		return wktime;
	}

	public void setWktime(String wktime) {
		this.wktime = wktime;
	}

	public String getOfftime() {
		return offtime;
	}

	public void setOfftime(String offtime) {
		this.offtime = offtime;
	}

}
