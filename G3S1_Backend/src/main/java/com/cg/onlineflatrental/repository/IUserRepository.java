package com.cg.onlineflatrental.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.capg.entity.User;


public interface UserRepository extends CrudRepository<User, Integer>{
	public Optional<User> findByUserName(String userName);
}