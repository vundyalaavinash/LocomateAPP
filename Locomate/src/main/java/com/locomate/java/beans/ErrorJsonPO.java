package com.locomate.java.beans;

import javax.persistence.Transient;

public class ErrorJsonPO {
	@Transient
	private String status = "error";
	@Transient
	private String message;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
