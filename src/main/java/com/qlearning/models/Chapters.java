package com.qlearning.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Chapters")
public class Chapters {

	@Id
	private ObjectId _id;

	private int chapter_id;
	private String chapter_name;

	public Chapters(ObjectId _id, int chapter_id, String chapter_name) {
		super();
		this._id = _id;
		this.chapter_id = chapter_id;
		this.chapter_name = chapter_name;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public int getChapter_id() {
		return chapter_id;
	}

	public void setChapter_id(int chapter_id) {
		this.chapter_id = chapter_id;
	}

	public String getChapter_name() {
		return chapter_name;
	}

	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}

}
