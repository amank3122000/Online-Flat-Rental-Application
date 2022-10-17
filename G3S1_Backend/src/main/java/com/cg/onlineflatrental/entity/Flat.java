package com.cg.onlineflatrental.entity;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;

@Entity
public class Flat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int flatId;
	
	@NotNull(message = "Please provide a valid cost")
	@Min(value = 1, message = "Cost should be more than 0")
	private float cost;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="houseNo")
	private FlatAddress flatAddress;
	
	@NotNull(message = "Flat availability is mandatory")
	private String availability;
	
	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	public Flat(int flatId, float cost, FlatAddress flatAddress, String availability, Landlord landlord) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availability = availability;
	}
  
	public int getFlatId() {
		return flatId;
	}
	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float flatCost) {
		this.cost = flatCost;
	}
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
  
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress
				+ ", flatAvailability=" + availability + "]";
	}
}
