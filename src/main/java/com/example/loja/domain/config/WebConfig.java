package com.example.loja.domain.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Esta anotação diz ao Spring que esta é uma classe de configuração
public class WebConfig implements WebMvcConfigurer { // Implementa a interface para configurar o MVC

	 @Override
	 public void addCorsMappings(CorsRegistry registry) {
	     registry.addMapping("/**")
	             .allowedOrigins(
	                 "http://localhost:3000",   // Seu frontend React
	                 "http://localhost:8080",
	                 "http://localhost:5500",
	                 "http://127.0.0.1:5500")
	             .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	             .allowedHeaders("*")   
	             .allowCredentials(true) 
	             .maxAge(3600);
	 }
}