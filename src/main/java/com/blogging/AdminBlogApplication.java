package com.blogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/** 
 * <h2> Main class - Launches the application </h2>   
 *    
 */  
@SpringBootApplication
public class AdminBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminBlogApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();		
	}
}
