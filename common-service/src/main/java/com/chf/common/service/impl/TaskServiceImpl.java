package com.chf.common.service.impl;

import java.util.Collection;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.tracker.ServiceTracker;

import com.chf.common.core.domain.Task;
import com.chf.common.core.persistence.TaskDao;
import com.chf.common.core.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {

	private TaskDao taskDao;

	private TaskDaoTracker taskDaoTracker;

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

	@Activate
	public void activate(BundleContext context) {
		taskDaoTracker = new TaskDaoTracker(context);
		taskDaoTracker.open();
	}

	@Deactivate
	public void deactivate() {
		taskDaoTracker.close();
	}

	class TaskDaoTracker extends ServiceTracker<TaskDao, TaskDao> {

		public TaskDaoTracker(BundleContext context) {
			super(context, TaskDao.class, null);
		}

		@Override
		public TaskDao addingService(ServiceReference<TaskDao> reference) {
			taskDao = super.addingService(reference);
			System.out.println(taskDao.getAll());
			return taskDao;
		}

	}
}
