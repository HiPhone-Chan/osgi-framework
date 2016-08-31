package com.chf.equinox;

import org.eclipse.core.runtime.adaptor.EclipseStarter;
import org.eclipse.osgi.framework.internal.core.FrameworkProperties;

public class EquinoxApp {

	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			args = new String[] { "-console" };
		}

		try {
			Object result = EclipseStarter.run(args, null);
			if (result instanceof Integer && !Boolean
					.valueOf(FrameworkProperties.getProperty(EclipseStarter.PROP_NOSHUTDOWN)).booleanValue()) {
				System.exit(((Integer) result).intValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
