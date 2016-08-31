package com.chf.osgi.log;

import org.osgi.service.log.LogEntry;

public final class NopLogger extends AbstractLogger {

	@Override
	public void log(LogEntry entry) {

	}

}
