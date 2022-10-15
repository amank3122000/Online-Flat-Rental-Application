package com.cg.onlineflatrental.entity;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class FlatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "flatId", unique = true)
	private Flat flat;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tenantId", unique = true)
	private Tenant tenantId;
	private Date bookingFromDate;
	private Date bookingToDate;
	
	public FlatBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlatBooking(Integer bookingNo, Flat flat, Tenant tenantId, Date bookingFromDate, Date bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenantId = tenantId;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}

	public Integer getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}
	public Flat getFlat() {
		return flat;
	}
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	public Tenant getTenantId() {
		return tenantId;
	}
	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}
	public Date getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(Date bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	public Date getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(Date bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
}

