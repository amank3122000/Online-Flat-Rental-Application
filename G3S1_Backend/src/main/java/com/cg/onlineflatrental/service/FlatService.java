package com.cg.onlineflatrental.service;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.repository.IFlatRepository;

@Service
public class FlatService implements IFlatService{
		 
		@Autowired
		private IFlatRepository flatRepository;

		@Override
		public Flat addFlat(Flat flat) {
			return flatRepository.save(flat);
		}
	
		@Override	
		public Flat updateFlat(Flat flat,int flatId) throws FlatNotFoundException {
			Flat f = flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
			f.setCost(flat.getCost());
			f.setAvailability(flat.getAvailability());
			f.setFlatAddress(flat.getFlatAddress());
			return flatRepository.save(f);
		}
		
		@Override	
		public void deleteFlat(int flatId)throws FlatNotFoundException{
			Flat f=flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
			flatRepository.delete(f);
		}
		
		@Override
		public Flat viewFlat(int flatId) throws FlatNotFoundException {
			return flatRepository.findById(flatId).orElseThrow(()->new FlatNotFoundException("Service.FLAT_NOT_FOUND"));
		}
		
		@Override
		public List<Flat> viewAllFlat() {
			return (List<Flat>) flatRepository.findAll();
		}
		
		@Override
		public List<Flat> findByCostAndAvailability(float cost,String availability){
	    		return flatRepository.findByCostAndAvailability(cost,availability);
	     }	
}
