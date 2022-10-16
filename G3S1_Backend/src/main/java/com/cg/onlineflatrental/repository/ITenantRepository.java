package com.cg.onlineflatrental.repository;

import java.util.List;
import java.util.Optional;

import com.cg.onlineflatrental.entity.Tenant;

public interface ITenantRepository {

	Tenant save(Tenant tenant);

	Optional<Tenant> findById(int tenantId);

	void delete(Tenant value);

	List<Tenant> findAll();

}
