package com.commu.model;

public class Fmes {
	private int mesId;
	private String name;
	private String title;
	private String message;
	private String time;
	private String acttime;
	private int praise;
	private int cmnum;
	
	public Fmes() {
	}

	public Fmes(int mesId, String name, String title, String message,
			String time, String acttime, int praise, int cmnum) {
		this.mesId = mesId;
		this.name = name;
		this.title = title;
		this.message = message;
		this.time = time;
		this.acttime = acttime;
		this.praise = praise;
		this.cmnum = cmnum;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public String getActtime() {
		return acttime;
	}

	public void setActtime(String acttime) {
		this.acttime = acttime;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}

	public int getCmnum() {
		return cmnum;
	}

	public void setCmnum(int cmnum) {
		this.cmnum = cmnum;
	}
	
	
}

/*
 * mesId int, name varchar(10), title varchar(50), message varchar(400), time
 * varchar(20), actiontime date, praise int, primary key(mesId) );
 */
