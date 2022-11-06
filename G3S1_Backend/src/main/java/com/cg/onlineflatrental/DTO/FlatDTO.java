package com.cg.onlineflatrental.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FlatDTO {
	
	private int flatId;
	@NotNull(message = "Please provide a valid cost")
	@Min(value = 1, message = "Cost should be more than 0")
    private float cost;
	
    private FlatAddressDTO flatAddress;
	@NotNull(message = "Flat availability is mandatory")
    private String availability;
    private LandlordDTO landlord;

    public FlatDTO() {
    	super();
    }

    public FlatDTO(int flatId, float cost, FlatAddressDTO flatAddress, String availability) {
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

    public void setCost(float cost) {
        this.cost = cost;
    }

    public FlatAddressDTO getFlatAddress() {
        return flatAddress;
    }

    public void setFlatAddress(FlatAddressDTO flatAddress) {
        this.flatAddress = flatAddress;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    
    public LandlordDTO getLandlord() {
		return landlord;
	}

	public void setLandlord(LandlordDTO landlord) {
		this.landlord = landlord;
	}

	@Override
    public String toString() {
        return "FlatDTO{" +
                "flatId=" + flatId +
                ", cost=" + cost +
                ", flatAddress=" + flatAddress +
                ", availability='" + availability + '\'' +
                '}';
    }
}

