package com.cg.onlineflatrental.DTO;

import java.sql.Date;

import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.Tenant;

public class FlatBookingDTO {
	private Integer bookingNo;
	private Flat flat;
	private Tenant tenantId;
	private Date bookingFromDate;
	private Date bookingToDate;
	
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
	public Date getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(Date bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public Date getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(Date bookingToDate) {
		this.bookingToDate = bookingToDate;
	}
	
	@Override
	public String toString() {
		return "FlatBookingDTO [bookingNo=" + bookingNo + ", flat=" + flat + ", tenantId=" + tenantId
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}
}

