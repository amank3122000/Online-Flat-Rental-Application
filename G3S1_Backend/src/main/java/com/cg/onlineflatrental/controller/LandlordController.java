package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.onlineflatrental.DTO.LandlordDTO;
import com.cg.onlineflatrental.entity.Landlord;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.service.LandlordService;

@RestController
@RequestMapping(value = "/onlineflatrental")
public class LandlordController {

	@Autowired
	private LandlordService landlordService;

	@Autowired
	private Environment environment;

	@GetMapping(value = "/landlord")
	public ResponseEntity<List<Landlord>> viewAllLandlord() {
		List<Landlord> landlordList = landlordService.viewAllLandlord();
		return new ResponseEntity<>(landlordList, HttpStatus.OK);
	}

	@GetMapping(value = "/landlord/{landlordId}")
	public ResponseEntity<Landlord> viewLandlord(@PathVariable Integer landlordId) throws LandlordNotFoundException {
		Landlord landlord = landlordService.viewLandlord(landlordId);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}

	@PostMapping(value = "/landlord")
	public ResponseEntity<String> addLandlord(@RequestBody Landlord landlord) {
		Landlord landlordId = landlordService.addLandlord(landlord);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + landlordId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value = "/landlord/{landlordId}")
	public ResponseEntity<String> updateLandlord(@PathVariable Integer landlordId, @RequestBody Landlord landlord)
			throws LandlordNotFoundException {
		landlordService.updateLandlord(landlordId, landlord);
		String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@DeleteMapping(value = "/landlord/{landlordId}")
	public ResponseEntity<String> deleteLandlord(@PathVariable Integer landlordId) throws LandlordNotFoundException {
		landlordService.deleteLandlord(landlordId);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}

