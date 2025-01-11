package com.diva.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.diva"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "My API Documentation",             // Title
            "This API provides various services for managing user data.",  // Description
            "1.0",                              // Version
            "https://www.example.com/terms",     // Terms of Service URL
            new Contact("John Doe", "https://www.johndoe.com", "john.doe@example.com"), // Contact
            "MIT License",                      // License
            "https://opensource.org/licenses/MIT", // License URL
            Collections.emptyList()             // Vendor Extensions
        );
    }

}