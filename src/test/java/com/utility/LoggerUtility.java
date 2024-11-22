package com.utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {

	//global config or setup for logger
	//using Singleton design pattern ----> this ensures that we have only a single object
	//singleton design pattern can be used for Logger utility and Database connectivity because we need only 1 object across the project

	//singleton design pattern , we have a PRIVATE CONSTRUCTOR
	private LoggerUtility() {
		
	}
	public static Logger getLogger(Class<?> clazz) {
		Logger logger = null;
		if(logger==null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
	}
}
