package com.cg.onlineflatrental.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.repository.ITenantRepository;
import com.cg.onlineflatrental.exception.TenantNotFoundException;

import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class TenantService implements ITenantService {
	private static final Logger logger = LogManager.getLogger(TenantService.class);
	@Autowired
	private ITenantRepository tenantRepository;
	/*
	 * This Method will add new Tenant
	 * Input parameter : Tenant Object
	 * Return Value: Tenant Object
	 * Exception : TenantNotFoundException
	 */
	@Override
	public Tenant addTenant(Tenant tenant) {
		logger.info("Called addTenant() method of TenantService");
		return tenantRepository.save(tenant);
	}
	/*
	 * This Method will Update Existing Tenants
	 * Input Parameter: Tenant Object,Integer tenantId
	 * Return Value: Tenant Object
	 * Exception: TenantNotFoundException
	 */
	@Override
	public Tenant updateTenant(int tenantId, Tenant tenant) throws TenantNotFoundException{
		logger.info("Called updateTenant() method of TenantService");
		Tenant value = tenantRepository.findById(tenantId).orElseThrow(() -> new TenantNotFoundException("Tenant with ID: " + tenantId +"does not exist."));
		value.setAge(tenant.getAge());
		value.setTaddress(tenant.getTaddress());
		return tenantRepository.save(value);
	}

	/*
	 * This method will Deletes existing Tenant
	 * Input Parameter : integer tenantId
	 * Return Value : Tenant Object 
	 * Exception : TenantNotFoundException
	 */

	@Override
	public void deleteTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called deleteTenant() method of TenantService");
		Tenant value = tenantRepository.findById(tenantId)
				.orElseThrow(() -> new TenantNotFoundException("Tenant with id " + tenantId + " does not exist."));
		tenantRepository.delete(value);
	}
	
	/*
	 * This method will Shows existing Tenant
	 * Input Parameter : integer tenantId
	 * Return Value : Tenant Object 
	 * Exception : TenantNotFoundException
	 */

	@Override
	public Tenant viewTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called viewTenant() method of TenantService");
		return tenantRepository.findById(tenantId).orElseThrow(
				() -> new TenantNotFoundException("Tenant With Given Id :" + tenantId + " Not Available!"));

	}
	
	/*
	 * This method will Shows all existing Tenants 
	 * Return Value : List<Tenant>
	 */

	@Override
	public Iterable<Tenant> viewAllTenant() {
		logger.info("Called viewAllTenant() method of TenantService");
		return tenantRepository.findAll();
	}
	
	/*
	 * This method will validate the Tenant
	 * Return Value(boolean) : Shows True if the object is present, shows false if the object is not present.
	 */

	@Override
	public boolean validateTenant(int tenantId) throws TenantNotFoundException {
		logger.info("Called validateTenant() method of TenantService");
		boolean flag = false;

		Optional<Tenant> tenant = tenantRepository.findById(tenantId);

		if (tenant == null)
			throw new TenantNotFoundException("Please check Tenant Id");
		else if (tenant.isPresent()) {
			flag = true;
		}

		else
			throw new TenantNotFoundException("Please check Tenant ID");
		
		return flag;
	}

}
