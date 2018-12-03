package com.pwc.r2p2.pojo;

import java.io.Serializable;

public class R2P2Task implements Serializable, Comparable<R2P2Task>{
	
	/**
	 * PwC IN
	 */
	private static final long serialVersionUID = 8635431502177840928L;
	
	private String id;
	private String name;
	private String assignee;
	private String isJBR;
	private String isNIS;
	private String sortValue;
	public String getId() {
		return id;
	}
	public String getSortValue() {
		return sortValue;
	}
	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getIsJBR() {
		return isJBR;
	}
	public void setIsJBR(String isJBR) {
		this.isJBR = isJBR;
	}
	public String getIsNIS() {
		return isNIS;
	}
	public void setIsNIS(String isNIS) {
		this.isNIS = isNIS;
	}
	@Override
	public int compareTo(R2P2Task arg0) {
		// TODO Auto-generated method stub
		return Integer.compare(Integer.parseInt(this.sortValue), Integer.parseInt(arg0.sortValue));
		
	}
	

}
