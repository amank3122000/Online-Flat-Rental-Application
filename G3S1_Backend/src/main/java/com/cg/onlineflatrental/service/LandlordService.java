package com.cg.onlineflatrental.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.Landlord;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.repository.ILandlordRepository;

@Service
public class LandlordService implements ILandlordService {

	@Autowired
	private ILandlordRepository landlordRepository;

	@Override
	public Landlord addLandlord(Landlord landlord) {
		landlordRepository.save(landlord);
		return landlord;
	}

	@Override
	public void deleteLandlord(Integer landlordId) throws LandlordNotFoundException {
		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		landlordRepository.deleteById(landlordId);
	}

	@Override
	public Landlord viewLandlord(Integer landlordId) throws LandlordNotFoundException {

		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		return landlordRepository.findById(landlordId).get();
	}

	@Override
	public List<Landlord> viewAllLandlord() {
		return (List<Landlord>) landlordRepository.findAll();
	}

	@Override
	public Landlord updateLandlord(Integer landlordId, Landlord landlord) throws LandlordNotFoundException {
		if (!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException("Service.LANDLORD_NOT_FOUND");
		}
		Landlord l = landlordRepository.findById(landlordId).get();
		l.setLandlordName(landlord.getLandlordName());
		l.setLandlordAge(landlord.getLandlordAge());
		l.setFlatList(landlord.getFlatList());

		return landlordRepository.save(l);
	}
}
