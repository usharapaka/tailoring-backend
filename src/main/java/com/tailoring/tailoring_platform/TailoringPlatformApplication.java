package com.tailoring.tailoring_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tailoring")
@EnableJpaRepositories(basePackages = "com.tailoring.repository")
@EntityScan(basePackages = "com.tailoring.entity")
public class TailoringPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(TailoringPlatformApplication.class, args);
    }
}