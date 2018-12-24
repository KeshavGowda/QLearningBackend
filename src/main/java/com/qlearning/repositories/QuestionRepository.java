package com.qlearning.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.qlearning.models.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {

	//Question findByQuestionId(int question_id);
	Question findByChapterIdAndQuestionId(int chapter_id, int question_id);
}
