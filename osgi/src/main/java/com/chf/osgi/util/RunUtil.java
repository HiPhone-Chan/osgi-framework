package com.chf.osgi.util;

import org.osgi.framework.FrameworkEvent;

import com.chf.osgi.OsgiFramework;

public final class RunUtil {

	private RunUtil() {
	}

	public static void run(String[] args, OsgiFramework osgiFramework) {
		FrameworkEvent event = null;
		do {
			osgiFramework.start();
			try {
				event = osgiFramework.waitForStop(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (event.getType() == FrameworkEvent.STOPPED_UPDATE);
	}

	public static <T extends OsgiFramework> void run(String[] args, Class<T> clz) {
		try {
			OsgiFramework osgiFramework = clz.newInstance();
			run(args, osgiFramework);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
