package com.cg.onlineflatrental.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.cg.onlineflatrental.entity.FlatAddress;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.repository.IFlatRepository;

@SpringBootTest
public class FlatServiceTest {

    @Autowired
    private FlatService flatService;

    @MockBean
    private IFlatRepository flatRepository;

    private static final Logger LOGGER = LogManager.getLogger(FlatServiceTest.class);

    Flat f1, f2, f3;
    Optional<Flat> f4, f5, f6;

    @BeforeAll
    public static void initBefore() {
        LOGGER.info("Flat module testing initialized");
    }

    @BeforeEach
    public void init() {
        f1 = new Flat(1, 2000, new FlatAddress(10,"Street1","City1","State1",123456,"Country1"),"available");
        f2 = new Flat(2, 4000, new FlatAddress(20,"Street2","City2","State2",234567,"Country2"),"available");
        f3 = new Flat(3, 6000, new FlatAddress(30,"Street3","City3","State3",345678,"Country3"),"available");

        f4 = Optional.of(f1);
        f5 = Optional.of(f2);
        f6 = Optional.of(f3);
    }

    @Test
    public void testAddFlat1() {
        when(flatRepository.save(f1)).thenReturn(f1);
        assertEquals(f1.getFlatId(),flatService.addFlat(f1).getFlatId());
        assertEquals(f1.getCost(),flatService.addFlat(f1).getCost());
        assertEquals(f1.getFlatAddress(),flatService.addFlat(f1).getFlatAddress());
        assertEquals(f1.getAvailability(),flatService.addFlat(f1).getAvailability());
    }

    @Test
    public void testAddFlat2() {
        when(flatRepository.save(f1)).thenReturn(f1);
        assertNotNull(flatService.addFlat(f1));
    }

    @Test
    public void testUpdateFlat1() throws FlatNotFoundException {
        when(flatRepository.existsById(f2.getFlatId())).thenReturn(true);
        when(flatRepository.findById(f2.getFlatId())).thenReturn(f5);
        when(flatRepository.save(f2)).thenReturn(f2);
        assertEquals(f2.getCost(),flatService.updateFlat(f2, f2.getFlatId()).getCost());
        assertEquals(f2.getFlatAddress(),flatService.updateFlat(f2,f2.getFlatId()).getFlatAddress());
        assertEquals(f2.getAvailability(),flatService.updateFlat(f2,f2.getFlatId()).getAvailability());
    }

    @Test
    public void testUpdateFlat2() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(false);
        FlatNotFoundException exception=assertThrows(FlatNotFoundException.class,()->flatService.updateFlat(f1,f1.getFlatId()));
        assertEquals("Service.FLAT_NOT_FOUND", exception.getMessage());
    }

    @Test
    public void testDeleteFlat1() throws FlatNotFoundException{
        when(flatRepository.existsById(f3.getFlatId())).thenReturn(true);
        when(flatRepository.findById(f3.getFlatId())).thenReturn(f6);
        flatService.deleteFlat(f3.getFlatId());
        verify(flatRepository).delete(f3);
    }

    @Test
    public void testDeleteFlat2() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(false);
        FlatNotFoundException exception=assertThrows(FlatNotFoundException.class,()->flatService.deleteFlat(f1.getFlatId()));
        assertEquals("Service.FLAT_NOT_FOUND", exception.getMessage());
    }

    @Test
    public void testViewFlat1() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(true);
        when(flatRepository.findById(f1.getFlatId())).thenReturn(f4);
        assertEquals(f1.getFlatId(),flatService.viewFlat(f1.getFlatId()).getFlatId());
        assertEquals(f1.getCost(),flatService.viewFlat(f1.getFlatId()).getCost());
        assertEquals(f1.getFlatAddress(),flatService.viewFlat(f1.getFlatId()).getFlatAddress());
        assertEquals(f1.getAvailability(),flatService.viewFlat(f1.getFlatId()).getAvailability());
    }

    @Test
    public void testViewFlat2() throws FlatNotFoundException {
        when(flatRepository.existsById(f1.getFlatId())).thenReturn(false);
        FlatNotFoundException exception=assertThrows(FlatNotFoundException.class,()->flatService.viewFlat(f1.getFlatId()));
        assertEquals("Service.FLAT_NOT_FOUND", exception.getMessage());
    }

    @Test
    public void testViewAllFlats() {
        List<Flat> f = new ArrayList<>();
        f.add(f1);
        f.add(f2);
        f.add(f3);
        when(flatRepository.findAll()).thenReturn(f);
        assertEquals(f.size(), flatService.viewAllFlat().size());
        assertArrayEquals(f.toArray(), flatService.viewAllFlat().toArray());
    }

    @Test
    public void testFindFlatsByCostAndAvailability() {
        List<Flat> f = new ArrayList<>();
        f.add(f1);
        f.add(f2);
        f.add(f3);
        List<Flat> fca = new ArrayList<>();
        for (Flat flat : f) {
            if (flat.getFlatId() == f2.getFlatId() && Objects.equals(flat.getAvailability(), f2.getAvailability())) {
                fca.add(flat);
            }
        }
        when(flatRepository.findByCostAndAvailability(f2.getCost(), f2.getAvailability())).thenReturn(fca);
        assertEquals(1,fca.size());
    }

    @AfterAll
    public static void end() {
        LOGGER.info("Flat module testing ended");
    }

}
