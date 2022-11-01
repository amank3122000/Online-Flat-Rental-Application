package com.cg.onlineflatrental.DTO;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LandlordDTO {
	private int landlordId;
	@NotNull(message = "Landlord name is mandatory")
	private String landlordName;
	@NotNull(message = "Landlord age is mandatory")
	@Min(value = 1, message = "Age should be more than 0")
	private int landlordAge;
	private List<FlatDTO> flatList;
	/**
	 * 
	 */
	public LandlordDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LandlordDTO(int landlordId, String landlordName, int landlordAge, List<FlatDTO> flatList) {
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
	public List<FlatDTO> getFlatList() {
		return flatList;
	}
	public void setFlatList(List<FlatDTO> flatList) {
		this.flatList = flatList;
	}
	@Override
	public String toString() {
		return "LandlordDTO [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge="
				+ landlordAge + ", flatList=" + flatList + "]";
	}
}
