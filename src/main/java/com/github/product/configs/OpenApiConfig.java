package com.github.product.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
            .title("Product Stock")
            .description("This is a project for WEB II")
            .version("1.0.0")
            .contact(apiContact());
    }

    private Contact apiContact() {
        return new Contact()
            .name("Frank Junior")
            .email("frank.junior.118@ufrn.edu.br")
            .url("https://github.com/franklaercio");
    }
}

