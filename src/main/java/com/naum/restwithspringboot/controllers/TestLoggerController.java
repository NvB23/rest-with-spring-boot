package com.naum.restwithspringboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLoggerController {

    private Logger logger = LoggerFactory.getLogger(TestLoggerController.class.getName());

    @GetMapping("/test")
    public String testLog() {
        logger.debug("This is an DEBUG logger.");
        logger.info("This is an INFO logger.");
        logger.warn("This is an WARNING logger.");
        logger.error("This is an ERROR logger.");
        return "Logs generated success!";
    }
}
