package com.pageBean;

import java.util.List;

public class PageBean<T> {
	private int pc;//当前页码page code
//	private int tp;//总页数totalPage
	private int tr;//总记录数total record
	private int ps;//每页记录数page size
	private int endNumber;//结束数
	private int beginNumber;//开始数
	private List<T> beanList;//当前页的记录
	public int getPc() {
		return pc;
	}
	public void setPc(int pc) {
		this.pc = pc;
	}
	
	public int getBeginNumber() {
		beginNumber = (pc-1)*ps+1;
		return beginNumber;
	}
	
	public int getEndNumber() {
		endNumber = pc*ps;
		return endNumber;
	}
	
	/**
	 * 计算总页数
	 * @return
	 */
	public int getTp() {
		int tp = tr / ps;
		return tr%ps==0 ? tp : tp+1 ;
	}
	 
	public int getTr() {
		return tr;
	}
	public void setTr(int tr) {
		this.tr = tr;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	
}
