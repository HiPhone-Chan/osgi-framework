package com.chf.osgi.log;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;
import org.osgi.util.tracker.ServiceTracker;

public class LogReaderServiceTracker extends ServiceTracker<LogReaderService, LogReaderService> {

	private LogListener logListener;

	public LogReaderServiceTracker(BundleContext context) {
		super(context, LogReaderService.class, null);
		logListener = new ConsoleLog();
	}

	@Override
	public LogReaderService addingService(ServiceReference<LogReaderService> reference) {
		LogReaderService logReaderService = super.addingService(reference);
		logReaderService.addLogListener(logListener);
		return logReaderService;
	}

	@Override
	public void removedService(ServiceReference<LogReaderService> reference, LogReaderService service) {
		service.removeLogListener(logListener);
		super.removedService(reference, service);
	}

}
