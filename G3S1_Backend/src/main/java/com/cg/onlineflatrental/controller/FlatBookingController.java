package com.cg.onlineflatrental.controller;

import java.util.List;

import com.cg.onlineflatrental.exception.FlatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.DTO.FlatBookingDTO;
import com.cg.onlineflatrental.DTO.FlatDTO;
import com.cg.onlineflatrental.DTO.TenantDTO;
import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatBooking;
import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.service.FlatService;
import com.cg.onlineflatrental.service.IFlatBookingService;
import com.cg.onlineflatrental.service.ITenantService;


@RestController
public class FlatBookingController {

    @Autowired
    private IFlatBookingService fbs;

    @Autowired
    private ITenantService tenantServ;

    @Autowired
    FlatService flatService;

    @PostMapping("/flatbooking")
    public ResponseEntity<String> addFlatBooking(@RequestBody FlatBookingDTO flat) throws TenantNotFoundException, FlatNotFoundException {
        flatService.viewFlat(flat.getFlat().getFlatId());
        tenantServ.viewTenant(flat.getTenantId().getTenantId());
        FlatDTO fb = fbs.addFlatBooking(flat);
        return new ResponseEntity<String>("FlatBooking created sucessfully.",HttpStatus.CREATED);
    }

    @GetMapping("/flatbookings")
    public ResponseEntity<List<FlatBookingDTO>> viewAllFlatBooking() {
        List<FlatBookingDTO> list=fbs.viewAllFlatBooking();
        return new ResponseEntity<List<FlatBookingDTO>>(list,HttpStatus.OK);
    }

    @GetMapping("/flatbooking/{id}")
    public ResponseEntity<FlatDTO> viewFlatBooking(@PathVariable int id) throws FlatBookingNotFoundException {
        FlatBookingDTO fb=fbs.viewFlatBooking(id);
        return new ResponseEntity<FlatDTO>(fb.getFlat(),HttpStatus.OK);
    }

    @DeleteMapping("/flatbooking/{id}")
    public ResponseEntity<String> deleteFlatBooking(@PathVariable int id) throws FlatBookingNotFoundException{
        fbs.deleteFlatBooking(id);
        return new ResponseEntity<String>("FlatBooking with Booking No: "+id+" sucessfully deleted.",HttpStatus.OK);
    }

    @PutMapping("/flatbooking/{id}")
    public ResponseEntity<FlatBookingDTO> updateFlatBooking(@RequestBody FlatBookingDTO flatbooking,@PathVariable int id) throws FlatBookingNotFoundException, TenantNotFoundException, FlatNotFoundException {
        FlatBookingDTO fb = fbs.updateFlatBooking(flatbooking,id);
        TenantDTO t = tenantServ.updateTenant(fb.getTenantId().getTenantId(), fb.getTenantId());
        FlatDTO f = flatService.updateFlat(fb.getFlat(),fb.getFlat().getFlatId());
        return new ResponseEntity<FlatBookingDTO>(fb,HttpStatus.ACCEPTED);

    }

}