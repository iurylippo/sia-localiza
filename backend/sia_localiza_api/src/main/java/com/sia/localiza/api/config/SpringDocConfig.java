package com.sia.localiza.api.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;

@Configuration
@OpenAPIDefinition
public class SpringDocConfig {
    @Bean
    OpenAPI baseOpenAPI() {
        ParseOptions parseOptions = new ParseOptions();
        parseOptions.setFlatten(true); 

        final OpenAPI openAPISchemas = new OpenAPIV3Parser().read("./docs/schemas.yaml", null, parseOptions);
        
        final OpenAPI openAPI = new OpenAPIV3Parser().read("./docs/doc.yaml", null, parseOptions);
        
        openAPI.info(new Info()
                        .description("Sia localiza Api")
                        .version("1.0.0")
                        .license(new License().name("MIT"))
                    );

        Server server = new Server().url("http://localhost:8000/api");
      
        
        openAPI.setServers(Arrays.asList(server));
        openAPI.setComponents(openAPISchemas.getComponents());
 

        return openAPI;
    }
}
