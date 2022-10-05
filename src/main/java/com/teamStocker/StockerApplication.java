package com.teamStocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class StockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockerApplication.class, args);
    }

}
