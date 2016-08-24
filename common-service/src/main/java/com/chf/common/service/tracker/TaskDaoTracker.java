package com.chf.common.service.tracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.chf.common.core.persistence.TaskDao;

public class TaskDaoTracker extends ServiceTracker<TaskDao, TaskDao> {

	public TaskDaoTracker(BundleContext context) {
		super(context, TaskDao.class, null);
	}

	@Override
	public TaskDao addingService(ServiceReference<TaskDao> reference) {
		TaskDao taskDao = super.addingService(reference);
		System.out.println(taskDao.getAll());
		return taskDao;
	}

	@Override
	public void removedService(ServiceReference<TaskDao> reference, TaskDao service) {
		super.removedService(reference, service);
	}

}
