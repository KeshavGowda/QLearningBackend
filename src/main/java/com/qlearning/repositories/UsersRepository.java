package com.qlearning.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qlearning.models.User;

public interface UsersRepository extends MongoRepository<User, String>{
	
	User findByUsername(String username);

}
