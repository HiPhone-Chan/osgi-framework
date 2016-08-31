package com.chf.felix.config;

import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;

public class LogConfig extends ConfigChain {

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		activators.add(new org.apache.felix.log.Activator());
	}

}
