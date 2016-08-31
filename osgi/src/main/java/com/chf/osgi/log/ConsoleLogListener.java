package com.chf.osgi.log;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;

public class ConsoleLogListener implements LogListener {

	@Override
	public void logged(LogEntry entry) {
		System.out.println(ConsoleLogger.logContent(entry));
	}

}
