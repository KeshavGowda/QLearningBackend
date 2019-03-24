package com.qlearning.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Learning")
public class Learning {
	
	@Id
	private ObjectId _id;
	
	private int learning_id;
	
	@Field ("chapter_id")
	private int chapterId;
	private String description;
	private String resource_link;
	private String resource_type;
	private String resource_length;
	private boolean completed;
	
	
	public String get_id() {
		return _id.toHexString();
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public int getLearning_id() {
		return learning_id;
	}
	
	public void setLearning_id(int learning_id) {
		this.learning_id = learning_id;
	}
	
	public int getChapter_id() {
		return chapterId;
	}
	
	public void setChapter_id(int chapter_id) {
		this.chapterId = chapter_id;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResource_link() {
		return resource_link;
	}
	
	public void setResource_link(String resource_link) {
		this.resource_link = resource_link;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getResource_type() {
		return resource_type;
	}

	public void setResource_type(String resource_type) {
		this.resource_type = resource_type;
	}

	public String getResource_length() {
		return resource_length;
	}

	public void setResource_length(String resource_length) {
		this.resource_length = resource_length;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
