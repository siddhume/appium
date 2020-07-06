package com.platform.project.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadPropertyClass {
	
	private static Logger logger = Logger.getLogger(ReadPropertyClass.class);
	
	private static String ConfigFileLocation="./src/test/resources/config.properties";
	private static String ConfigFileLocationQA="./src/test/resources/configQA.properties";
	private static String ConfigFileLocationDev="./src/test/resources/configDev.properties";
	
	private static String readFile(String file, String key) {
		String value=null;
		
		try {
			Properties prop=new Properties();
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
			value=prop.getProperty(key);
						
		} catch(IOException ioe) {
			ioe.printStackTrace();
			logger.info("Couldn't locate the property file ");
		}
		
		logger.info("Value in property file for " + key + " is "+ value);
		return value;
		
	}
	
	
	public static String getConfigPropertyVal(final String key) {
		String configPropertyValue;
		if (CreateEnvVariable.createEnvVariable("env").equalsIgnoreCase("QA")){
			configPropertyValue=readFile(ConfigFileLocationQA,key);
			logger.info("getting properties from QA config file");
		}
		else if (CreateEnvVariable.createEnvVariable("env").equalsIgnoreCase("Dev")){
			 configPropertyValue=readFile(ConfigFileLocationDev,key);
			 logger.info("getting properties from Dev Config file");
		}
		else {
			configPropertyValue=readFile(ConfigFileLocation,key);
			logger.info("getting properties from default config file" );
		}
		
		
			
		
		
//		if(configPropertyValue!=null) {
//			return configPropertyValue.trim();
//		}
//		else {
//			return configPropertyValue;
//		}
		
		// can write this if/else
		return configPropertyValue!=null ? configPropertyValue.trim() :configPropertyValue;
		
	}
	
	
	
	
	
	
	
	

}
