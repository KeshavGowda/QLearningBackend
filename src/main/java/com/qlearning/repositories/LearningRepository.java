package com.qlearning.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.qlearning.models.Learning;

public interface LearningRepository extends MongoRepository<Learning, String>{
	
	Learning findBy_id(ObjectId _id);
	
	List<Learning> findByChapterId(int chapter_id);

}
