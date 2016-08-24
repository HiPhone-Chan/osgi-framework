package com.chf.common.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start common.");

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop common.");
	}

}
