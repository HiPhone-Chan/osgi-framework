package com.chf.felix;

import static org.apache.felix.framework.util.FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.fileinstall.internal.DirectoryWatcher;
import org.apache.felix.fileinstall.internal.FileInstall;
import org.apache.felix.framework.FrameworkFactory;
import org.apache.felix.http.whiteboard.internal.WhiteboardActivator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.Constants;

import com.chf.felix.activator.HttpActivator;
import com.chf.osgi.OsgiFramework;
import com.chf.osgi.activator.HostActivator;

public class FelixFramework extends OsgiFramework {

	private Map<String, Object> config;

	protected void init() {
		FrameworkFactory factory = (FrameworkFactory) getFrameworkFactory();
		if (factory != null) {
			config = initConfig();
			framework = factory.newFramework(config);
		} else {
			System.err.println("Cannot find factory.");
		}

	}

	private Map<String, Object> initConfig() {
		Map<String, Object> config = new HashMap<>();
		List<BundleActivator> activators = new ArrayList<BundleActivator>();

		// HostActivator
		activators.add(new HostActivator());
		// log
		activators.add(new org.apache.felix.log.Activator());
		// gogo
		activators.add(new org.apache.felix.gogo.runtime.activator.Activator());
		activators.add(new org.apache.felix.gogo.command.Activator());
		activators.add(new org.apache.felix.gogo.shell.Activator());
		activators.add(new org.apache.felix.bundlerepository.impl.Activator());

		// file install do not read the jar's initial-bundles directory
		activators.add(new FileInstall());
		config.put(DirectoryWatcher.DIR, "/initial-bundles");

		// src
		activators.add(new org.apache.felix.scr.impl.Activator());

		// http
		activators.add(new WhiteboardActivator());
		activators.add(new HttpActivator());
		config.put("org.apache.felix.http.jettyEnabled", "true");
		config.put("org.apache.felix.http.whiteboardEnabled", "true");

		// preset bundles
		config.put(SYSTEMBUNDLE_ACTIVATORS_PROP, activators);

		// extra packages
		config.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA, "javax.servlet;javax.servlet.http;version=2.5");
		return config;
	}

}
