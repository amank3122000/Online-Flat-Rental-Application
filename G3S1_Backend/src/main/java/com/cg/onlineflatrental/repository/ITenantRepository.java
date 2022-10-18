package com.cg.onlineflatrental.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.cg.onlineflatrental.entity.Tenant;

public interface ITenantRepository extends CrudRepository <Tenant,Integer>{

}
