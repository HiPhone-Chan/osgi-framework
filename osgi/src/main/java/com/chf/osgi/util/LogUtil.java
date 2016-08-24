package com.chf.osgi.util;

import static org.osgi.service.log.LogService.LOG_DEBUG;
import static org.osgi.service.log.LogService.LOG_ERROR;
import static org.osgi.service.log.LogService.LOG_INFO;
import static org.osgi.service.log.LogService.LOG_WARNING;

import java.util.Date;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogService;

public final class LogUtil {
	private LogUtil() {
	}

	private static LogService logService;

	public static void init(LogService logSer) {
		logService = logSer;
	}

	public static void debug(String message) {
		logService.log(LOG_DEBUG, message);
	}

	public static void info(String message) {
		logService.log(LOG_INFO, message);
	}

	public static void warn(String message) {
		logService.log(LOG_WARNING, message);
	}

	public static void error(String message) {
		logService.log(LOG_ERROR, message);
	}

	public static String logContent(LogEntry entry) {
		StringBuilder sb = new StringBuilder();
		sb.append(new Date(entry.getTime()).toString()).append(" [").append(logLevel(entry.getLevel())).append("] ")
				.append(entry.getMessage()).append(". - ").append(entry.getServiceReference());
		Throwable t = entry.getException();
		if (t != null) {
			sb.append("\n").append(t);
		}
		return sb.toString();
	}

	public static String logLevel(int level) {
		switch (level) {
		case LOG_DEBUG:
			return "DEBUG";
		case LOG_INFO:
			return "INFO";
		case LOG_WARNING:
			return "WARNING";
		case LOG_ERROR:
			return "ERROR";
		default:
		}
		return "UNKOWN";
	}
}
