package com.chf.felix.config;

import java.util.List;
import java.util.Map;

import org.apache.aries.blueprint.container.BlueprintExtender;
import org.osgi.framework.BundleActivator;

public class BlueprintConfig extends ConfigChain {

	@Override
	public void config(Map<String, Object> config, List<BundleActivator> activators) {
		activators.add(new BlueprintExtender());
	}

}
