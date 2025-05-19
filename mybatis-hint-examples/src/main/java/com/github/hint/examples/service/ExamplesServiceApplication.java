package com.github.hint.examples.service;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ExamplesServiceApplication
 * @Description
 * @Author wzq
 * @Date 2025/5/19 15:59
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan({"com.github.hint.**.mapper*"})
public class ExamplesServiceApplication {

    private static final Logger logger = LoggerFactory.getLogger(ExamplesServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExamplesServiceApplication.class, args);
        logger.info("************************* start end *************************");
    }
}
