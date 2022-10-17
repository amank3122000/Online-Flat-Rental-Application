package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.exception.FlatNotFoundException; 

public interface IFlatService {
  
		public Flat addFlat(Flat flat);  
		public Flat updateFlat(Flat flat,int flatId) throws FlatNotFoundException;
		public void deleteFlat(int id) throws FlatNotFoundException; 
		public Flat viewFlat(int FlatId)throws FlatNotFoundException;
		public List<Flat> viewAllFlat(); 
		public List<Flat> findByCostAndAvailability(float cost, String availability);		
}
