package com.cg.onlineflatrental.DTO;

import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.entity.Landlord;

public class FlatDTO {
    private int flatId;
    private float cost;
    private FlatAddress flatAddress;
    private String availability;
    private Landlord landlord;

    public FlatDTO() {
    }

    public FlatDTO(int flatId, float cost, FlatAddress flatAddress, String availability) {
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
        return "FlatDTO{" +
                "flatId=" + flatId +
                ", cost=" + cost +
                ", flatAddress=" + flatAddress +
                ", availability='" + availability + '\'' +
                '}';
    }
}

