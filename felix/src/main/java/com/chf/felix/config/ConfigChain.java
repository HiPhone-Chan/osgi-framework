package com.chf.felix.config;

import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleActivator;

public abstract class ConfigChain {

	protected ConfigChain nextConfig;

	public abstract void config(Map<String, Object> config, List<BundleActivator> activators);

	public Map<String, Object> startConfig(Map<String, Object> config, List<BundleActivator> activators) {
		this.config(config, activators);
		return nextConfig != null ? nextConfig.startConfig(config, activators) : config;
	}

	public ConfigChain addConfig(ConfigChain nextConfig) {
		this.nextConfig = nextConfig;
		return nextConfig;
	}

	public ConfigChain addConfig(Class<? extends ConfigChain> configClass) {
		try {
			this.nextConfig = configClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			this.nextConfig = new NoConfig();
		}
		return nextConfig;
	}

	public class NoConfig extends ConfigChain {

		@Override
		public void config(Map<String, Object> config, List<BundleActivator> activators) {
		}

	}
}
