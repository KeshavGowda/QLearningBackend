package com.qlearning.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qlearning.models.UserTransaction;

public interface UserTxnRepository extends MongoRepository<UserTransaction, String> {

}
