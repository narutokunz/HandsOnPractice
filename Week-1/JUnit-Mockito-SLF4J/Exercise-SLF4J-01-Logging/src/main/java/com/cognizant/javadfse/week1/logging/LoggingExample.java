package com.cognizant.javadfse.week1.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.error("Critical failure detected in payment gateway integration");
        logger.warn("Retry threshold exceeded for order batch processing");
        logger.info("Application started successfully");
    }
}
