package com.cg.onlineflatrental.DTO;

import java.sql.Date;

public class FlatBookingDTO {
	private Integer bookingNo;
	private FlatDTO flat;
	private TenantDTO tenantId;
	private Date bookingFromDate;
	private Date bookingToDate;
	
	public FlatBookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlatBookingDTO(Integer bookingNo, FlatDTO flat, TenantDTO tenantId, Date bookingFromDate,
			Date bookingToDate) {
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
	
	public FlatDTO getFlat() {
		return flat;
	}
	public void setFlat(FlatDTO flat) {
		this.flat = flat;
	}
	public TenantDTO getTenantId() {
		return tenantId;
	}
	public void setTenantId(TenantDTO tenantId) {
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

