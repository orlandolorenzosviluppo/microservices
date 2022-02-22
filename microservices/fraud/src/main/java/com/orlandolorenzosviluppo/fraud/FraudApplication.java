package com.orlandolorenzosviluppo.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan("com.orlandolorenzosviluppo.fraud.model")
@EnableConfigurationProperties
@EnableEurekaClient
@SpringBootApplication
public class FraudApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class, args);
    }
}
