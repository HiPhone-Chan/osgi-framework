package com.chf.common.service.impl;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import org.ops4j.pax.cdi.api.Properties;
import org.ops4j.pax.cdi.api.Property;

import com.chf.common.core.domain.Task;
import com.chf.common.core.persistence.TaskDao;
import com.chf.common.core.service.TaskService;

@OsgiServiceProvider(classes = { TaskService.class })
@Properties({ @Property(name = "service.exported.interfaces", value = "*") })
@Named
public class TaskServiceImpl implements TaskService {

	@Inject
	@OsgiService
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
