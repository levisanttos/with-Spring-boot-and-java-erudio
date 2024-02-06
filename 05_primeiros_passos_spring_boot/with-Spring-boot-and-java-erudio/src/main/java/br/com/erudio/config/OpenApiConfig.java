package br.com.erudio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI custonOpen() {
		return new OpenAPI()
				.info(new Info()
						.title("REST API's RESTFul do 0 à AWS c. Spring Boot 3 Java e Docker")
						.version("V1")
						.description("Estudo de criações de microsserviços")
						.contact(new Contact().email("levidossanttos@gmail.com"))
						.license(new License().name("Apche 2.0")));
	}
}
