package com.cg.onlineflatrental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatBooking;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.repository.IFlatBookingRepository;

@Service
public class FlatBookingService implements IFlatBookingService {

    @Autowired
    private IFlatBookingRepository fbRepo;

    @Override
    public Flat addFlatBooking(FlatBooking flat) {
        FlatBooking fb=fbRepo.save(flat);
        return fb.getFlat();
    }

    @Override
    public List<FlatBooking> viewAllFlatBooking() {
        List<FlatBooking> list=(List)fbRepo.findAll();
        System.out.println("Data From DB :");
        list.forEach(FlatBooking->{
            System.out.println("Tenant Id :"+FlatBooking.getTenantId());
            System.out.println("Booking Number :"+FlatBooking.getBookingNo());
            System.out.println("Booking from Date :"+FlatBooking.getBookingFromDate());
            System.out.println("Booking to Date :"+FlatBooking.getBookingToDate());
        });
        return list;
    }

    @Override
    public FlatBooking viewFlatBooking(int id) throws FlatBookingNotFoundException{
        Optional<FlatBooking> fb=fbRepo.findById(id);
        if(fb.isEmpty())
            throw new FlatBookingNotFoundException("flat booking does not exist");
        else
            return fb.get();

    }

    @Override
    public void deleteFlatBooking(int id) throws FlatBookingNotFoundException {
        Optional<FlatBooking> fb= fbRepo.findById(id);
        if(fb.isEmpty())
            throw new FlatBookingNotFoundException("flat booking does not exist");
        else
            fbRepo.delete(fb.get());
    }

    @Override
    public FlatBooking updateFlatBooking(FlatBooking flat, int id) throws FlatBookingNotFoundException {
        Optional<FlatBooking> fb= fbRepo.findById(id);
        if(fb.isEmpty())
            throw new FlatBookingNotFoundException("flat booking does not exist");
        else {
            fb.get().setFlat(flat.getFlat());
            fb.get().setTenantId(flat.getTenantId());
            fb.get().setBookingFromDate(flat.getBookingFromDate());
            fb.get().setBookingToDate(flat.getBookingToDate());
        }
        return fbRepo.save(fb.get());
    }


}