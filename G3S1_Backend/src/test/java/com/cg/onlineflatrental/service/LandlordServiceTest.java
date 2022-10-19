package com.cg.onlineflatrental.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.entity.Landlord;
import com.cg.onlineflatrental.exception.LandlordNotFoundException;
import com.cg.onlineflatrental.repository.ILandlordRepository;


@SpringBootTest
public class LandlordServiceTest {
	
	@Autowired 
	private LandlordService service;
	
	@MockBean
	private ILandlordRepository repository;
	
	private static final Logger LOGGER = LogManager.getLogger(LandlordServiceTest.class);
	
	private Optional<Landlord> landlord3;
	private Landlord landlord1 ,landlord2,l3;
	private Flat flat1, flat2, flat3;

	
	@BeforeAll
	public static void initBefore() {
		LOGGER.info("Landlord module testing initialized");
	}
	
	@BeforeEach
	public void init() {
		
		List<Flat> flat_list1 = new ArrayList<Flat>();
		flat_list1.add(flat1);
		flat_list1.add(flat2);
		List<Flat> flat_list2 = new ArrayList<Flat>();
		flat_list2.add(flat3);
		
		landlord1 = new Landlord(1,"John",33,flat_list1);
		landlord2 = new Landlord(2,"Ahmed",42,flat_list2);
		l3 = new Landlord(3,"Dev",38,flat_list1);
		landlord3 = Optional.of(l3);
		
	}
	
	@Test
	public void testAddLandlord1() {
		when(repository.save(landlord1)).thenReturn(landlord1);
		assertEquals(landlord1.getLandlordAge(),service.addLandlord(landlord1).getLandlordAge());
		assertEquals(landlord1.getLandlordId(),service.addLandlord(landlord1).getLandlordId());
		assertEquals(landlord1.getLandlordName(),service.addLandlord(landlord1).getLandlordName());
		assertEquals(landlord1.getFlatList(),service.addLandlord(landlord1).getFlatList());
	}
	
	@Test
	public void testAddLandlord2() {
		when(repository.save(landlord1)).thenReturn(landlord1);
		assertNotNull(service.addLandlord(landlord1));
	}
	
	@Test
	public void testUpdateLandlord1() throws LandlordNotFoundException{
		when(repository.existsById(landlord3.get().getLandlordId())).thenReturn(true);
		when(repository.findById(landlord3.get().getLandlordId())).thenReturn(landlord3);
		when(repository.save(landlord3.get())).thenReturn(landlord3.get());
		assertEquals(landlord3.get().getLandlordAge(),service.updateLandlord(landlord3.get().getLandlordId(),landlord3.get()).getLandlordAge());
		assertEquals(landlord3.get().getLandlordName(),service.updateLandlord(landlord3.get().getLandlordId(),landlord3.get()).getLandlordName());
		assertEquals(landlord3.get().getFlatList(),service.updateLandlord(landlord3.get().getLandlordId(),landlord3.get()).getFlatList());
	}
	
	@Test
	public void testUpdateLandlord2() throws LandlordNotFoundException {
		when(repository.existsById(landlord1.getLandlordId())).thenReturn(false);
		LandlordNotFoundException exception=assertThrows(LandlordNotFoundException.class,()->service.updateLandlord(landlord1.getLandlordId(),landlord1));
		assertEquals("Service.LANDLORD_NOT_FOUND", exception.getMessage());
	}
	
	@Test
	public void testDeleteLandlord1() throws LandlordNotFoundException{
		when(repository.existsById(landlord3.get().getLandlordId())).thenReturn(true);
		when(repository.findById(landlord3.get().getLandlordId())).thenReturn(landlord3);
		service.deleteLandlord(landlord3.get().getLandlordId());
		verify(repository).deleteById(landlord3.get().getLandlordId());
	}
	
	@Test
	public void testDeleteLandlord2() throws LandlordNotFoundException {
		when(repository.existsById(landlord1.getLandlordId())).thenReturn(false);
		LandlordNotFoundException exception=assertThrows(LandlordNotFoundException.class,()->service.deleteLandlord(landlord1.getLandlordId()));
		assertEquals("Service.LANDLORD_NOT_FOUND", exception.getMessage());
	}
	
	
	@Test
	public void testViewLandlord1() throws LandlordNotFoundException{
		when(repository.existsById(landlord3.get().getLandlordId())).thenReturn(true);
		when(repository.findById(landlord3.get().getLandlordId())).thenReturn(landlord3);
		assertEquals(landlord3.get().getLandlordAge(),service.viewLandlord(landlord3.get().getLandlordId()).getLandlordAge());
		assertEquals(landlord3.get().getLandlordId(),service.viewLandlord(landlord3.get().getLandlordId()).getLandlordId());
		assertEquals(landlord3.get().getLandlordName(),service.viewLandlord(landlord3.get().getLandlordId()).getLandlordName());
		assertEquals(landlord3.get().getFlatList(),service.viewLandlord(landlord3.get().getLandlordId()).getFlatList());
	}
	
	@Test
	public void testViewLandlord2() throws LandlordNotFoundException {
		when(repository.existsById(landlord1.getLandlordId())).thenReturn(false);
		LandlordNotFoundException exception=assertThrows(LandlordNotFoundException.class,()->service.viewLandlord(landlord1.getLandlordId()));
		assertEquals("Service.LANDLORD_NOT_FOUND", exception.getMessage());
	}
	
	@Test
	public void testViewAllLandlord() {
		List<Landlord> l = new ArrayList<Landlord>();
		l.add(landlord1);
		l.add(landlord2);
		when(repository.findAll()).thenReturn(l);
		assertEquals(l.size(), service.viewAllLandlord().size());
		assertArrayEquals(l.toArray(), service.viewAllLandlord().toArray());
	
	}
	
	@AfterAll
	public static void end() {
		LOGGER.info("Landlord module testing ended");
	}

}
