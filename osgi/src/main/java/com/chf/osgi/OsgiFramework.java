package com.chf.osgi;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.BundleException;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import com.chf.osgi.util.LogUtil;

public class OsgiFramework {

	protected Framework framework;

	public OsgiFramework() {
		init();
	}

	protected void init() {
		FrameworkFactory factory = getFrameworkFactory();
		if (factory != null) {
			Map<String, String> config = new HashMap<>();
			framework = factory.newFramework(config);
		} else {
			System.out.println("Cannot find factory.");
		}
	}

	public void start() {
		try {
			framework.start();
			LogUtil.info("Framework started");
		} catch (BundleException e) {
			throw new RuntimeException(e);
		}
	}

	public void stop() {
		try {
			if (framework != null) {
				framework.stop();
				waitForStop(0);
			}
		} catch (BundleException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public FrameworkEvent waitForStop(long timeout) throws InterruptedException {
		return framework.waitForStop(timeout);
	}

	protected FrameworkFactory getFrameworkFactory() {
		ServiceLoader<FrameworkFactory> serviceLoader = ServiceLoader.load(FrameworkFactory.class);
		for (FrameworkFactory factory : serviceLoader) {
			return factory;
		}
		return null;
	}

}
