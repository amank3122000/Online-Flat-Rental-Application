package com.cg.onlineflatrental.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cg.onlineflatrental.entity.Tenant;

public interface ITenantRepository extends CrudRepository <Tenant,Integer>{

	public Optional<Tenant> findById(int tenantId);

}
