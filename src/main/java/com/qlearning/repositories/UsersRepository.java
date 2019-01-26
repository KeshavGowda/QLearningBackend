package com.qlearning.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qlearning.models.Users;

public interface UsersRepository extends MongoRepository<Users, String>{
	
	Users findByUsername(String username);

}
