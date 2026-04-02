package com.destination.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI destinationApiDocs() {
        return new OpenAPI()
                .info(new Info()
                        .title("Destination API")
                        .description("REST API for managing webhook and API destinations")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Destination API")
                                .url("https://github.com/gaurav")));
    }
}
