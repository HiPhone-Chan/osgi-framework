package com.chf.common.service.impl;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;

import com.chf.common.core.domain.Task;
import com.chf.common.core.persistence.TaskDao;
import com.chf.common.core.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {

	private TaskDao taskDao;

	@Override
	public Task getTask(String id) {
		return taskDao.get(id);
	}

	@Override
	public void addTask(Task task) {
		taskDao.add(task);
	}

	@Override
	public Collection<Task> getTasks() {
		return taskDao.getAll();
	}

	@Override
	public void updateTask(Task task) {
		taskDao.update(task);
	}

	@Override
	public void deleteTask(String id) {
		taskDao.delete(id);
	}

}
