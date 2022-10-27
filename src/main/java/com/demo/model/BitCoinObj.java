package com.demo.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Bit_Coin_Obj")
public class BitCoinObj {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="serial_no")
	private int serialNo;
	
	@Column(name="received_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date receivedAt;
	
	@Column(name="amount")
	private double amount;
	
	public BitCoinObj(Date receivedAt, double amount) {
		this.receivedAt = receivedAt;
		this.amount = amount;
	}
	public BitCoinObj(int serialNo, Date receivedAt, double amount) {
		this.serialNo = serialNo;
		this.receivedAt = receivedAt;
		this.amount = amount;
	}
	
	public Date getReceivedAt() {
		return receivedAt;
	}
	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public BitCoinObj() {
	}
	
	
}
