package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static springfox.documentation.builders.PathSelectors.regex;


@Configuration
@EnableSwagger2
public class Config {
	 @Bean
	 public Docket postsApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	            .select()
	            .paths(regex("/.*"))
	            .build();
	    
	}

	private ApiInfo apiInfo() {

	        ApiInfo apiInfo = new ApiInfo(
	            "Spring Boot Swagger2 Example API",
	            null,
	            "1.0",
	            "Terms of Service",
	            new Contact("Your Name or Team", null,
	                null),
	            "Apache License Version 2.0",
	            "https://www.apache.org/licenses/"
	        );

	        return apiInfo;
	    }
	
	
}
