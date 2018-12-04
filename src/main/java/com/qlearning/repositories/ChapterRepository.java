package com.qlearning.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.qlearning.models.Chapters;

public interface ChapterRepository extends MongoRepository<Chapters, String>{
	
	Chapters findBy_id(ObjectId _id);

}
