package com.chf.felix;

import java.util.Map;

import org.apache.felix.framework.FrameworkFactory;

import com.chf.felix.config.BundleRepositoryConfig;
import com.chf.felix.config.ExtraPackagesConfig;
import com.chf.felix.config.FelixConfig;
import com.chf.felix.config.FileInstallConfig;
import com.chf.felix.config.GogoConfig;
import com.chf.felix.config.HttpConfig;
import com.chf.felix.config.LogConfig;
import com.chf.felix.config.ScrConfig;
import com.chf.osgi.OsgiFramework;

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
		FelixConfig config = new FelixConfig();
		config.addConfig(LogConfig.class).addConfig(BundleRepositoryConfig.class).addConfig(GogoConfig.class)
				.addConfig(FileInstallConfig.class).addConfig(ScrConfig.class).addConfig(HttpConfig.class)
				.addConfig(ExtraPackagesConfig.class);
		return config.startConfig();
	}

}
