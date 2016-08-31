package com.chf.common.core.domain;

import java.util.Date;

public class Task {

	private String id;

	private String title;

	private Date date;

	public Task() {
	}

	public Task(String id, String title) {
		this.id = id;
		this.title = title;
		this.date = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", date=" + date + "]";
	}

}
