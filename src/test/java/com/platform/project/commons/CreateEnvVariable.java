package com.platform.project.commons;

import org.apache.log4j.Logger;

public class CreateEnvVariable {
	private static Logger logger = Logger.getLogger(CreateEnvVariable.class);

	public static String createEnvVariable(String envVariableName, String defaultValue) {
		String value = System.getProperty((envVariableName));

		logger.info("environment value for " + envVariableName + " is " + value);

		return value != null ? value : defaultValue;
	}

	public static String createEnvVariable(String envVariableName) {
		String value = System.getProperty((envVariableName));

		// logger.info("environment value for " + envVariableName + " is "+ value);
		String defaultValue = "notFound";
		return value != null ? value : defaultValue;

	}

}
