package com.commu.model;

import java.util.List;

public class Comm {
	private int cmId;
	private int mesId;
	private String name;
	private String cmmes;
	private String time;
	private int disum;
	private List<Disp> disps;
	
	public Comm() {
	}

	public Comm(int cmId, int mesId, String name, String cmmes, String time,
			int disum, List<Disp> disps) {
		this.cmId = cmId;
		this.mesId = mesId;
		this.name = name;
		this.cmmes = cmmes;
		this.time = time;
		this.disum = disum;
		this.disps = disps;
	}

	public int getCmId() {
		return cmId;
	}

	public void setCmId(int cmId) {
		this.cmId = cmId;
	}

	public int getMesId() {
		return mesId;
	}

	public void setMesId(int mesId) {
		this.mesId = mesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDisum() {
		return disum;
	}

	public void setDisum(int disum) {
		this.disum = disum;
	}

	public List<Disp> getDisps() {
		return disps;
	}

	public void setDisps(List<Disp> disps) {
		this.disps = disps;
	}

	public String getCmmes() {
		return cmmes;
	}

	public void setCmmes(String cmmes) {
		this.cmmes = cmmes;
	}
	
}

/*drop table bs_comm;
create table bs_comm(
cmId int,
mesId int,
name varchar(10),
time varchar(20)
);*/