package com.mydemo.resttemplate.common.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintSwaggerUrlApplicationRunner implements ApplicationRunner {

    @Value("${server.port}")
    private Integer serverPort;

    private static Logger logger = LoggerFactory.getLogger(PrintSwaggerUrlApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Swagger Url: http://localhost:" + serverPort + "/swagger-ui.html");
    }
}
