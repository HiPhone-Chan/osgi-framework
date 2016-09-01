package com.chf.common.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.chf.common.service.tracker.TaskDaoTracker;

public class Activator implements BundleActivator {

	private TaskDaoTracker taskDaoTracker;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start service.");
		taskDaoTracker = new TaskDaoTracker(context);
		taskDaoTracker.open();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop service.");
		taskDaoTracker.close();
	}

}
