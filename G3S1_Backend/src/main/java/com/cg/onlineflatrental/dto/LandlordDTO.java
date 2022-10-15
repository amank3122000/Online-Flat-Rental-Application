package com.cg.onlineflatrental.dto;

import java.util.List;

import com.cg.onlineflatrental.entity.Flat;


public class LandlordDTO {

	private int landlordId;
	private String landlordName;
	private int landlordAge;
	private List<Flat> flatList;
  
	public LandlordDTO() {}
	public LandlordDTO( String landlordName, int landlordAge, List<Flat> flatList) {
		super();
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}
	public Integer getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(Integer landlordId) {
		this.landlordId = landlordId;
	}
	public String getLandlordName() {
		return landlordName;
	}
	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}
	public int getLandlordAge() {
		return landlordAge;
	}
	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}
	public List<Flat> getFlatList() { 
		  return flatList; 
	} 
	public void setFlatList(List<Flat> flatList) { 
		  this.flatList = flatList;
	}
	@Override
	public String toString() {
		return "LandlordDTO [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + "]";
	}
}