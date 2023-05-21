package com.sia.localiza.api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("com.sia.localiza.api.*")
@ComponentScan(basePackages = { "com.sia.localiza.api.*" })
@EntityScan("com.sia.localiza.api.*")   
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}