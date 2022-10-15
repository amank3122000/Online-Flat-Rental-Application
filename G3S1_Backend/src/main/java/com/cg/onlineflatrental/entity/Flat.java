package com.cg.onlineflatrental.entity;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Flat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int flatId;
	
	//@Column(name="FlatCost")
	private float cost;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="houseNo")
	private FlatAddress flatAddress;
	
	//@Column(name="FlatAvailability")
	private String availability;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="landlordId")
	//private Landlord landlord;
	
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