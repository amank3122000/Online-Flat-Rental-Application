package com.cg.onlineflatrental.service;

import java.util.List;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatBooking;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {
    public Flat addFlatBooking(FlatBooking flat);
    public FlatBooking updateFlatBooking(FlatBooking flat,int id) throws FlatBookingNotFoundException;
    public void deleteFlatBooking(int id) throws FlatBookingNotFoundException;
    public FlatBooking viewFlatBooking(int id) throws FlatBookingNotFoundException;
    public List<FlatBooking> viewAllFlatBooking();

}