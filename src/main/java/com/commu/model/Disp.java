package com.commu.model;

public class Disp {
	private int dispId;
	private int cmId;
	private String byname;
	private String toname;
	private String time;
	
	public Disp() {
	}

	public Disp(int dispId, int cmId, String byname, String toname, String time) {
		this.dispId = dispId;
		this.cmId = cmId;
		this.byname = byname;
		this.toname = toname;
		this.time = time;
	}

	public int getDispId() {
		return dispId;
	}

	public void setDispId(int dispId) {
		this.dispId = dispId;
	}

	public int getCmId() {
		return cmId;
	}

	public void setCmId(int cmId) {
		this.cmId = cmId;
	}

	public String getByname() {
		return byname;
	}

	public void setByname(String byname) {
		this.byname = byname;
	}

	public String getToname() {
		return toname;
	}

	public void setToname(String toname) {
		this.toname = toname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}

/*create table bs_disp(
dispId int,
cmId int,
byname varchar(10),
toname varchar(10),
time varchar(20),
primary key(dispId)
);*/