package com.chf.osgi.log;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogService;
import org.osgi.util.tracker.ServiceTracker;

import com.chf.osgi.util.LogUtil;

public class LogServiceTracker extends ServiceTracker<LogService, LogService> {

	private LogReaderServiceTracker logReaderServiceTracker;

	public LogServiceTracker(BundleContext context) {
		super(context, LogService.class, null);
		logReaderServiceTracker = new LogReaderServiceTracker(context);
	}

	@Override
	public LogService addingService(ServiceReference<LogService> reference) {
		LogService logService = super.addingService(reference);
		LogUtil.init(logService);
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
