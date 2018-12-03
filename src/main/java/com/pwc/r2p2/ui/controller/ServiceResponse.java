package com.pwc.r2p2.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ServiceResponse implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5680015567063788335L;
	private String status;
	private String token;
	private String msg;
	private List<?> dataList;
	private Object data;
	
		
	
	/**
	 * @param status
	 * @param token
	 * @param msg
	 */
	public ServiceResponse(String status, String token, String msg) {
		super();
		this.status = status;
		this.token = token;
		this.msg = msg;
	}
	
	public ServiceResponse(String status, String token, String msg, Object data) {
		super();
		this.status = status;
		this.token = token;
		this.msg = msg;
		this.data = data;
	}
	
	//public ServiceResponse(String status, String token, List<?> dataList) {
		//super();
		//this.status = status;
		//this.token = token;
	//	this.dataList = dataList;
	//}
	public ServiceResponse(String status, String token, ArrayList dataList) {
		super();
		this.status = status;
		this.token = token;
		this.dataList = dataList;
	}
	
	
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
	
	/*
	public String toString()
	{
	  return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}*/
}
