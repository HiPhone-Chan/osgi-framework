package com.chf.common.core.service;

import java.util.Collection;

import com.chf.common.core.domain.Task;

public interface TaskService {

	Task getTask(String id);

	void addTask(Task task);

	void updateTask(Task task);

	void deleteTask(String id);

	Collection<Task> getTasks();
}
