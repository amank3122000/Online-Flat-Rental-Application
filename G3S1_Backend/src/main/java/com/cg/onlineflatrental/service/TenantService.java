package com.cg.onlineflatrental.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.entity.Tenant;
import com.cg.onlineflatrental.repository.ITenantRepository;
import com.cg.onlineflatrental.exception.TenantNotFoundException;
import java.util.Optional;
public class TenantService implements ITenantService {
	private static final Logger logger = LogManager.getLogger(TenantService.class);
	@Autowired
	private ITenantRepository tenantRepository;
	
}
