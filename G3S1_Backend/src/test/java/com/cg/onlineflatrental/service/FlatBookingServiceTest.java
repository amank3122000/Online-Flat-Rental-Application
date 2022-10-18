package com.cg.onlineflatrental.service;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.FlatAddress;
import com.cg.onlineflatrental.entity.FlatBooking;
import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.FlatBookingNotFoundException;
import com.cg.onlineflatrental.repository.IFlatBookingRepository;



@SpringBootTest
public class FlatBookingServiceTest {

    @Autowired
    private FlatBookingService service;

    @MockBean
    private IFlatBookingRepository repository;

    Optional<FlatBooking> flatbooking3;
    FlatBooking flatbooking1, flatbooking2;

    private Flat flat1, flat2, flat3;
    private Tenant tenant1, tenant2, tenant3;
    @BeforeEach		//Define flat list also for below test cases
    public void init() {
        LocalDate fromdate=LocalDate.of(2021,06, 20);
        LocalDate todate=LocalDate.of(2021,07, 19);
        flat1 = new Flat(1, 2000, new FlatAddress(10,"Street1","City1","State1",123456,"Country1"),"available");
        flat2 = new Flat(2, 4000, new FlatAddress(20,"Street2","City2","State2",234567,"Country2"),"available");
        flat3 = new Flat(3, 6000, new FlatAddress(30,"Street3","City3","State3",345678,"Country3"),"available");

        flatbooking1 = new FlatBooking(1, flat1, tenant1, fromdate, todate);
        flatbooking2 = new FlatBooking(2, flat2, tenant2, fromdate, todate);
        flatbooking3 = Optional.of(new FlatBooking(3, flat3, tenant3, fromdate ,todate));
    }

    @Test
    public void testAddFlatBooking() {
        when(repository.save(flatbooking1)).thenReturn(flatbooking1);
        assertEquals(flatbooking1.getFlat().getFlatId(),service.addFlatBooking(flatbooking1).getFlatId());
        assertEquals(flatbooking1.getFlat().getCost(),service.addFlatBooking(flatbooking1).getCost());
        assertEquals(flatbooking1.getFlat().getFlatAddress(),service.addFlatBooking(flatbooking1).getFlatAddress());
        assertEquals(flatbooking1.getFlat().getAvailability(),service.addFlatBooking(flatbooking1).getAvailability());
    }

    @Test
    public void testUpdateFlatBooking() throws FlatBookingNotFoundException {
        when(repository.findById(flatbooking3.get().getBookingNo())).thenReturn(flatbooking3);
        when(repository.save(flatbooking3.get())).thenReturn(flatbooking3.get());
        assertEquals(flatbooking3.get().getBookingNo(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getBookingNo());
        assertEquals(flatbooking3.get().getFlat(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getFlat());
        assertEquals(flatbooking3.get().getTenantId(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getTenantId());
        assertEquals(flatbooking3.get().getBookingFromDate(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getBookingFromDate());
        assertEquals(flatbooking3.get().getBookingToDate(),service.updateFlatBooking(flatbooking3.get(),flatbooking3.get().getBookingNo()).getBookingToDate());
    }

    @Test
    public void testDeleteFlatBooking() throws FlatBookingNotFoundException {
        when(repository.findById(flatbooking3.get().getBookingNo())).thenReturn(flatbooking3);
        service.deleteFlatBooking(flatbooking3.get().getBookingNo());
        verify(repository, times(1)).delete(flatbooking3.get());
    }

    @Test
    public void testViewFlatBooking() throws FlatBookingNotFoundException {
        when(repository.findById(flatbooking3.get().getBookingNo())).thenReturn(flatbooking3);
        assertEquals(flatbooking3.get().getBookingNo(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getBookingNo());
        assertEquals(flatbooking3.get().getFlat(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getFlat());
        assertEquals(flatbooking3.get().getTenantId(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getTenantId());
        assertEquals(flatbooking3.get().getBookingFromDate(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getBookingFromDate());
        assertEquals(flatbooking3.get().getBookingToDate(),service.viewFlatBooking(flatbooking3.get().getBookingNo()).getBookingToDate());
    }

    @Test
    public void testViewAllFlatBooking() {
        List<FlatBooking> l = new ArrayList<FlatBooking>();
        l.add(flatbooking1);
        l.add(flatbooking2);
        when(repository.findAll()).thenReturn(l);
        assertEquals(l.size(), service.viewAllFlatBooking().size());
        assertArrayEquals(l.toArray(), service.viewAllFlatBooking().toArray());
    }

}