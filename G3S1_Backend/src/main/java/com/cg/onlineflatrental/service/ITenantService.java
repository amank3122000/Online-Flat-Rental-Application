package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.exception.TenantNotFoundException;

public interface ITenantService {

	Tenant addTenant(Tenant tenant);
	Tenant updateTenant(int tenantId, Tenant tenant) throws TenantNotFoundException;
	void deleteTenant(int tenantId) throws TenantNotFoundException;
	Tenant viewTenant(int tenantId) throws TenantNotFoundException;
	boolean validateTenant(int tenantId) throws TenantNotFoundException;
	List<Tenant> viewAllTenant();

}
