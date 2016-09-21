package com.chf.ui.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.chf.common.core.domain.Task;

@XmlRootElement
public class TaskDto {

	private String id;

	private String title;

	private Date date;

	public TaskDto() {
	}

	public TaskDto(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.date = task.getDate();
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
