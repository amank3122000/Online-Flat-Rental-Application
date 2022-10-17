package com.cg.onlineflatrental.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import com.cg.onlineflatrental.service.ITenantService;

@RestController
  public class TenantController {
	
  @Autowired
  private ITenantService tenantServ;
 
	@PostMapping("/tenant")
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
		return new ResponseEntity<>(tenantServ.addTenant(tenant), HttpStatus.CREATED);
	}
	
	@PutMapping("/tenant/{tenantId}")
	public ResponseEntity<Tenant> updateTenant(@PathVariable int tenantId, @RequestBody Tenant tenant)
			throws TenantNotFoundException {
		Tenant t = tenantServ.updateTenant(tenantId, tenant);
		return new ResponseEntity<Tenant>(t, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/tenant/{tenantId}")
	public ResponseEntity<String> deleteTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		tenantServ.deleteTenant(tenantId);
		return new ResponseEntity<String>("Tenant with Tenant Id " + tenantId + " deleted successfuly", HttpStatus.OK);

	}

	@GetMapping("/tenants")
	public ResponseEntity<List<Tenant>> viewAllTenant() {
		List<Tenant> list = tenantServ.viewAllTenant();
		return new ResponseEntity<List<Tenant>>(list, HttpStatus.OK);
	}

	@GetMapping("/tenant/{tenantId}")
	public ResponseEntity<Tenant> viewTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		Tenant t = tenantServ.viewTenant(tenantId);
		return new ResponseEntity<Tenant>(t, HttpStatus.OK);

	}
	
	@PatchMapping("/tenant/{tenantId}")
	public ResponseEntity<String>validateTenant(@PathVariable int tenantId) throws TenantNotFoundException {
		if(!tenantServ.validateTenant(tenantId)) {
			return new ResponseEntity<String>("Tenant Id not match", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("Tenant Id Matched", HttpStatus.ACCEPTED);
		}
	}



	}


