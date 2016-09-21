package com.chf.ui;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.chf.ui.command.MyCommand;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start ui.");

		new MyCommand(context);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop ui.");
	}

}
