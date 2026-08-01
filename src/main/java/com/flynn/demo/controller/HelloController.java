package com.flynn.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "guest") String name) {
        // 打印不同级别的日志，便于后续在 Grafana 中筛选
        logger.info("Processing hello request for user: {}", name);
        
        if ("error".equalsIgnoreCase(name)) {
            logger.error("Triggered test error log for Loki tracking!");
            return "Error logged!";
        }
        
        return "Hello, " + name + "!";
    }
}