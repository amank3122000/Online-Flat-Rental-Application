package com.cg.onlineflatrental.DTO;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FlatBookingDTO {
	private Integer bookingNo;
	@NotNull
	@Valid
	private FlatDTO flat;
	@NotNull
	@Valid
	private TenantDTO tenantId;
	@NotNull(message = "Booking From Date is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate bookingFromDate;
	@NotNull(message = "Booking To Date is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate bookingToDate;
	
	public FlatBookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlatBookingDTO(Integer bookingNo, FlatDTO flat, TenantDTO tenantId, LocalDate bookingFromDate,
			LocalDate bookingToDate) {
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
	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}
	
	@Override
	public String toString() {
		return "FlatBookingDTO [bookingNo=" + bookingNo + ", flat=" + flat + ", tenantId=" + tenantId
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}
}

