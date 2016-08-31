package com.chf.osgi.log;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;

import com.chf.osgi.simplify.SimpleServiceTracker;

public class LogServiceTracker extends SimpleServiceTracker<LogService> {

	private LogReaderServiceTracker logReaderServiceTracker;

	public LogServiceTracker(BundleContext context) {
		super(context, LogService.class);
		logReaderServiceTracker = new LogReaderServiceTracker(context);
	}

	@Override
	public LogService addingService(ServiceReference<LogService> reference) {
		LogService logService = context.getService(reference);
		SystemLogger.init(logService);
		return logService;
	}

	@Override
	public void open() {
		logReaderServiceTracker.open();
		super.open();
	}

	@Override
	public void close() {
		logReaderServiceTracker.close();
		super.close();
	}
}
