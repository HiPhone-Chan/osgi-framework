package com.chf.ui.command;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;

public class MyCommand {

	public static final String[] COMMANDS = { "hello" };

	public static final String COMMAND_SCOPE = "osgi.command.scope";
	public static final String COMMAND_FUNCTION = "osgi.command.function";

	private BundleContext context;

	public MyCommand(BundleContext context) {
		this.context = context;
		config();
	}

	public void hello(String name) {
		System.out.println("hello from " + name);
	}

	public void config() {
		Dictionary<String, Object> props = new Hashtable<>();
		props.put(COMMAND_SCOPE, "chf");
		props.put(COMMAND_FUNCTION, COMMANDS);
		context.registerService(getClass().getName(), this, props);
	}

}
