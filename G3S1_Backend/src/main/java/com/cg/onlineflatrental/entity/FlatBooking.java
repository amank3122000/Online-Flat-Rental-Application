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
	@JoinColumn(name = "flatId", unique = true)
	private Tenant tenantId;
	private Date bookingFromDate;
	private Date bookingToDate;
	
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
}

