package com.pwc.r2p2.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestDetails implements Serializable {

	private static final long serialVersionUID = -5474312784939105929L;

	private String requestId;
	private String tertiaryCategoryId;
	private String taskName;
	private String requester;
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getTertiaryCategoryId() {
		return tertiaryCategoryId;
	}
	public void setTertiaryCategoryId(String tertiaryCategoryId) {
		this.tertiaryCategoryId = tertiaryCategoryId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}
	
}
