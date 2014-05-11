package com.locomate.java.beans;

import java.util.ArrayList;

import javax.persistence.Transient;

public class ObjectCollectionPO {
	@Transient
	private String status;
	@Transient
	private ArrayList<Object> arrayList;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Object> getArrayList() {
		return arrayList;
	}
	public void setArrayList(ArrayList<Object> arrayList) {
		this.arrayList = arrayList;
	}
	
	
	
}
