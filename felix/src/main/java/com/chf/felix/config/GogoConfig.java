package com.chf.felix.config;

import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;

public class GogoConfig extends ConfigChain {

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		activators.add(new org.apache.felix.gogo.runtime.activator.Activator());
		activators.add(new org.apache.felix.gogo.command.Activator());
		activators.add(new org.apache.felix.gogo.shell.Activator());

	}

}
