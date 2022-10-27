package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BitCoin {

	//private int serialNo;
	private String receivedAt;
	private double amount;
	
	//work around
	private String fromDate;
	private String toDate;
	
	public BitCoin(String receivedAt, float amount) {
		this.receivedAt = receivedAt;
		this.amount = amount;
	}
	
	public BitCoin(String fromDate, String toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(String receivedAt) {
		this.receivedAt = receivedAt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public BitCoin() {
		
	}
	
}
