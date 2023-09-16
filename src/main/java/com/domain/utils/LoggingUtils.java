package com.domain.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingUtils {

    private static final Logger logger = LogManager.getLogger(LoggingUtils.class);

    public void doSomething() {
        logger.info("This is an info message.");
        logger.error("This is an error message.");
    }
}
