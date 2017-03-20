package com.commu.model;

public class Message {
	private int mId;
	private String message;
	private String byname;
	private String toname;
   	private String time;
	private int mark;
   	
   	public Message() {
	}

	public Message(int mId, String message, String byname, String toname,
			String time, int mark) {
		this.mId = mId;
		this.message = message;
		this.byname = byname;
		this.toname = toname;
		this.time = time;
		this.mark = mark;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
}
