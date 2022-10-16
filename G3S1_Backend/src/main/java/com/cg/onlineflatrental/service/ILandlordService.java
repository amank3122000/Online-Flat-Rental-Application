package com.cg.onlineflatrental.service;

import java.util.List;
import com.cg.onlineflatrental.entity.Landlord;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;

public interface ILandlordService {
	public Landlord addLandlord(Landlord landlord);

	public Landlord updateLandlord(Integer landlordId, Landlord landlord) throws LandlordNotFoundException;

	public void deleteLandlord(Integer landlordId) throws LandlordNotFoundException;

	public Landlord viewLandlord(Integer landlordId) throws LandlordNotFoundException;

	public List<Landlord> viewAllLandlord();

}