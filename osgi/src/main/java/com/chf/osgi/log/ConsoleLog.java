package com.chf.osgi.log;

import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;

import com.chf.osgi.util.LogUtil;

public class ConsoleLog implements LogListener {

	@Override
	public void logged(LogEntry entry) {
		System.out.println(LogUtil.logContent(entry));
	}

}
