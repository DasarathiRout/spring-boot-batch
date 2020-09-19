package com.dasarathi.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainDriverSpringBoot implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(MainDriverSpringBoot.class);
    private static final String line = "#########################################################";


    public static void main(String[] arrays) {
        SpringApplication.run(MainDriverSpringBoot.class, arrays);
    }

    @Override
    public void run(String... arrays){
        try {
            LOG.error("http:localhost:9898/api/v1/spring/boot/actuator");
            LOG.error("http:localhost:9898/api/v1/h2console");
        } catch (Exception e) {
            LOG.error("");
        } finally {
            System.gc();
            LOG.error(line+"    BATCH RUN ENDED    "+line);
        }
    }

}