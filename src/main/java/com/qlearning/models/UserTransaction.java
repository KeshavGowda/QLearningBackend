package com.qlearning.models;

import java.sql.Timestamp;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "User_Transaction")
public class UserTransaction {

	@Id
	private ObjectId _id;

	@Field("question_id")
	private int txn_id;
	private int user_id;
	private int chapter_id;
	private int learning_id;
	private List<QuestionsAttempted> questions_attempted;
	private Timestamp last_visited;

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public int getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(int txn_id) {
		this.txn_id = txn_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}

	public int getLearning_id() {
		return learning_id;
	}

	public void setLearning_id(int learning_id) {
		this.learning_id = learning_id;
	}

	public List<QuestionsAttempted> getQuestions_attempted() {
		return questions_attempted;
	}

	public void setQuestions_attempted(List<QuestionsAttempted> questions_attempted) {
		this.questions_attempted = questions_attempted;
	}

	public Timestamp getLast_visited() {
		return last_visited;
	}

	public void setLast_visited(Timestamp last_visited) {
		this.last_visited = last_visited;
	}
}
