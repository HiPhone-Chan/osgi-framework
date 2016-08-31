package com.chf.osgi.log;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogListener;
import org.osgi.service.log.LogReaderService;

import com.chf.osgi.simplify.SimpleServiceTracker;

public class LogReaderServiceTracker extends SimpleServiceTracker<LogReaderService> {

	private LogListener logListener;

	public LogReaderServiceTracker(BundleContext context) {
		super(context, LogReaderService.class);
		logListener = new ConsoleLogListener();
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
