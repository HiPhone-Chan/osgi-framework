package com.chf.osgi.simplify;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class SimpleServiceTracker<T> extends ServiceTracker<T, T> {

	public SimpleServiceTracker(BundleContext context, Class<T> clazz) {
		super(context, clazz, null);
	}

	public SimpleServiceTracker(BundleContext context, String clazz) {
		super(context, clazz, null);
	}

	public SimpleServiceTracker(BundleContext context, Class<T> clazz, ServiceTrackerCustomizer<T, T> customizer) {
		super(context, clazz, customizer);
	}

}
