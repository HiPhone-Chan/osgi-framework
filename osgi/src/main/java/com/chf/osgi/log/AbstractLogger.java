package com.chf.osgi.log;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogService;

@SuppressWarnings("rawtypes")
public abstract class AbstractLogger implements LogService {

	public void log(int level, String message) {
		log(null, level, message, null);
	}

	public void log(int level, String message, Throwable cause) {
		log(null, level, message, cause);
	}

	public void log(ServiceReference ref, int level, String message) {
		log(ref, level, message, null);
	}

	public void log(ServiceReference sr, int level, String message, Throwable exception) {
		log(new SimpleLogEntry(sr, level, message, exception));
	}

	public abstract void log(LogEntry entry);

	class SimpleLogEntry implements LogEntry {

		private ServiceReference ref;
		private int level;
		private String message;
		private Throwable exception;

		public SimpleLogEntry(ServiceReference ref, int level, String message, Throwable exception) {
			this.ref = ref;
			this.level = level;
			this.message = message;
			this.exception = exception;
		}

		@Override
		public Bundle getBundle() {
			return null;
		}

		@Override
		public ServiceReference getServiceReference() {
			return ref;
		}

		@Override
		public int getLevel() {
			return level;
		}

		@Override
		public String getMessage() {
			return message;
		}

		@Override
		public Throwable getException() {
			return exception;
		}

		@Override
		public long getTime() {
			return System.currentTimeMillis();
		}

	}
}
