package com.locomate.java.beans;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="offers")
public class PostRidePO {
	@Id
	@GeneratedValue
    @Column(name="idoffer")	
	private long idoffer;
	
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
	
	@Column(name="amount")
	private double amount;
		
	@Column(name="instructions")
	private String  instructions;
	
	@Column(name="availableseats")
	private int availableseats;
	
	@Column(name="vehiclenumber")
	private String vehiclenumber;
	
	@Column(name="vehiclemodel")
	private String vehiclemodel;
	
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
	
	

	public PostRidePO() {
		super();
	}
	
	public PostRidePO(String username, String fromAddress,
			String toAddress, String frequency, Calendar startDateTime,
			String days, double amount, String instructions,
			int availableseats, String vehiclenumber, String vehiclemodel,
			Calendar createdon) {
		super();
		this.username = username;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.frequency = frequency;
		this.startDateTime = startDateTime;
		this.days = days;
		this.amount = amount;
		this.instructions = instructions;
		this.availableseats = availableseats;
		this.vehiclenumber = vehiclenumber;
		this.vehiclemodel = vehiclemodel;
		this.createdon = createdon;
	}

	public long getRideId() {
		return idoffer;
	}

	public void setRideId(long rideId) {
		this.idoffer = rideId;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public String getVehiclenumber() {
		return vehiclenumber;
	}

	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}

	public String getVehiclemodel() {
		return vehiclemodel;
	}

	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public Calendar getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Calendar createdon) {
		this.createdon = createdon;
	}
	
	
	

}
