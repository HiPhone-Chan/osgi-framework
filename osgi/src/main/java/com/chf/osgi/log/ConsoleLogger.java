package com.chf.osgi.log;

import java.io.PrintStream;
import java.util.Date;

import org.osgi.service.log.LogEntry;

public class ConsoleLogger extends AbstractLogger {

	private final PrintStream out;

	public ConsoleLogger() {
		out = System.out;
	}

	@Override
	public void log(LogEntry entry) {
		out.println(logContent(entry));
	}

	public static String logContent(LogEntry entry) {
		StringBuilder sb = new StringBuilder();
		sb.append(new Date(entry.getTime()).toString()).append(" [").append(logLevel(entry.getLevel())).append("] ")
				.append(entry.getMessage()).append(". - ").append("[").append(entry.getBundle().getSymbolicName())
				.append("][").append(entry.getServiceReference()).append("]");
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
