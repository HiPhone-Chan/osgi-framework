package com.chf.osgi.log;

import static org.osgi.service.log.LogService.LOG_DEBUG;
import static org.osgi.service.log.LogService.LOG_ERROR;
import static org.osgi.service.log.LogService.LOG_INFO;
import static org.osgi.service.log.LogService.LOG_WARNING;

import org.osgi.service.log.LogService;

import com.chf.osgi.log.NopLogger;

public final class SystemLogger {
	private SystemLogger() {
	}

	private static final LogService NOP_LOGGER = new NopLogger();

	private static LogService logger;

	public static void init(LogService logSer) {
		logger = logSer;
	}

	private static LogService getLogger() {
		return logger != null ? logger : NOP_LOGGER;
	}

	public static void debug(String message) {
		getLogger().log(LOG_DEBUG, message);
	}

	public static void info(String message) {
		getLogger().log(LOG_INFO, message);
	}

	public static void warn(String message) {
		getLogger().log(LOG_WARNING, message);
	}

	public static void error(String message) {
		getLogger().log(LOG_ERROR, message);
	}
}
