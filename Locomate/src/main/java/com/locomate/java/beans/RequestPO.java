package com.locomate.java.beans;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="requests")
public class RequestPO {
	@Id
	@GeneratedValue
    @Column(name="idrequests")	
	private long idrequests;
	
	@Column(name="username")
	private String username;
	
	@Column(name="fromAddress")
	private String fromAddress;
	
	@Column(name="toAddress")
	private String toAddress;
	
	@Column(name="frequency")
	private String frequency;
	
	@Column(name="startDate")
	private Calendar startDateTime;
	
	@Column(name="days")
	private String days;
	
	@Column(name="createdon")
	private Calendar createdon;
	
	@Transient
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	

	public RequestPO() {
		super();
	}
	
	public RequestPO(String username, String fromAddress,
			String toAddress, String frequency, Calendar startDateTime,
			String days, Calendar createdon) {
		super();
		this.username = username;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.frequency = frequency;
		this.startDateTime = startDateTime;
		this.days = days;
		this.createdon = createdon;
	}

	public long getRideId() {
		return idrequests;
	}

	public void setRideId(long rideId) {
		this.idrequests = rideId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Calendar getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Calendar startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Calendar getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Calendar createdon) {
		this.createdon = createdon;
	}
	
	
	

}
