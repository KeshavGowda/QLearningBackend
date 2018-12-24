package com.qlearning.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Questions")
public class Question {

	@Id
	private ObjectId _id;

	@Field("question_id")
	private int questionId;
	
	@Field("chapter_id")
	private int chapterId;
	private String question;
	private String answer;
	private String[] options;

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public int getQuestion_id() {
		return questionId;
	}

	public void setQuestion_id(int questionId) {
		this.questionId = questionId;
	}

	public int getChapter_id() {
		return chapterId;
	}

	public void setChapter_id(int chapter_id) {
		this.chapterId = chapter_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
}
