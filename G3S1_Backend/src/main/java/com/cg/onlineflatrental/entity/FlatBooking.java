package com.cg.onlineflatrental.entity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

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
	@NotNull(message = "dateOfBirth is required")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate bookingFromDate;
	@NotNull(message = "dateOfBirth is required")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate bookingToDate;
	
	public FlatBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlatBooking(Integer bookingNo, Flat flat, Tenant tenantId, LocalDate bookingFromDate, LocalDate bookingToDate) {
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
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}
	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	@Override
	public String toString() {
		return "FlatBooking{" +
				"bookingNo=" + bookingNo +
				", flat=" + flat +
				", tenantId=" + tenantId +
				", bookingFromDate=" + bookingFromDate +
				", bookingToDate=" + bookingToDate +
				'}';
	}
}

