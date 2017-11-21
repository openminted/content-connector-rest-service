package eu.openminted.content.rest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "eu.openminted.content")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
