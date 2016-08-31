package com.chf.felix.config;

import java.util.List;
import java.util.Map;

import org.apache.felix.fileinstall.internal.DirectoryWatcher;
import org.apache.felix.fileinstall.internal.FileInstall;
import org.osgi.framework.BundleActivator;

public class FileInstallConfig extends ConfigChain {

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		activators.add(new FileInstall());
		config.put(DirectoryWatcher.DIR, "/initial-bundles");
	}

}
