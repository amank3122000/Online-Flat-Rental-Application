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

import com.cg.onlineflatrental.entity.Flat;
import com.cg.onlineflatrental.exception.FlatNotFoundException;
import com.cg.onlineflatrental.service.FlatService;

@RestController
@RequestMapping(value = "/onlineflatrental")
public class FlatController {

    @Autowired
    private FlatService flatService;

    @Autowired
    private Environment environment;

    @PostMapping(value = "/flat")
    public ResponseEntity<Flat> addFlat(@RequestBody Flat flat) {
        return new ResponseEntity<>(flatService.addFlat(flat), HttpStatus.CREATED);
    }

    @PutMapping("/flat/{flatId}")
    public ResponseEntity<String> updateFlat(@RequestBody Flat flat, @PathVariable Integer flatId)
            throws FlatNotFoundException {
        flatService.updateFlat(flat, flatId);
        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @DeleteMapping(value = "/flat/{flatId}")
    public ResponseEntity<String> deleteFlat(@PathVariable Integer flatId) throws FlatNotFoundException {
        flatService.deleteFlat(flatId);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping(value = "/flat/{flatId}")
    public ResponseEntity<Flat> viewFlat(@PathVariable Integer flatId) throws FlatNotFoundException {
        Flat flat = flatService.viewFlat(flatId);
        return new ResponseEntity<>(flat, HttpStatus.OK);
    }

    @GetMapping(value = "/flat")
    public ResponseEntity<List<Flat>> viewAllFlat() {
        List<Flat> flatList = flatService.viewAllFlat();
        return new ResponseEntity<>(flatList, HttpStatus.OK);
    }

    @GetMapping("flat/{cost}/{availability}")
    public List<Flat> findByCostAndAvailability(@PathVariable("cost") float cost, @PathVariable("availability") String availability) {
        return flatService.findByCostAndAvailability(cost, availability);
    }

}
