package com.sia.localiza.api.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

// @Configuration
@OpenAPIDefinition
public class SpringDocConfig {
    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI().info(new Info().title("TEST").version("1.0.0"));
    }

    // @Bean
    // public GroupedOpenApi httpApi() {
    //     return GroupedOpenApi.builder()
    //             .group("http")
    //             .pathsToMatch("/**")
    //             .build();
    // }
}
