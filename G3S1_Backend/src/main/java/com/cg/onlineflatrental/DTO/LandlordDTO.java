package com.cg.onlineflatrental.DTO;

import java.util.List;
import com.cg.onlineflatrental.entity.Flat;

public class LandlordDTO {
	private int landlordId;
	private String landlordName;
	private int landlordAge;
	private List<Flat> flatList;
	/**
	 * 
	 */
	public LandlordDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param landlordId
	 * @param landlordName
	 * @param landlordAge
	 * @param flatList
	 */
	public LandlordDTO(int landlordId, String landlordName, int landlordAge, List<Flat> flatList) {
		super();
		this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
	}
	
	public int getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(int landlordId) {
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
		return "LandlordDTO [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge="
				+ landlordAge + ", flatList=" + flatList + "]";
	}
}