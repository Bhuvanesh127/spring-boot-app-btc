package com.demo.model;

import java.util.Date;

import javax.persistence.Entity;

//@Entity
public class DateRange {

	private Date fromDate;
	private Date toDate;
	
	public DateRange(Date fromDate, Date toDate) {
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	public DateRange() {
		
	}
	
}
