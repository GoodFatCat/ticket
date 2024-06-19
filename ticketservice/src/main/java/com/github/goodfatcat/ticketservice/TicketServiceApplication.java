package com.github.goodfatcat.ticketservice;

import java.awt.image.BufferedImage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

@SpringBootApplication
public class TicketServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketServiceApplication.class, args);
	}
	
	@Bean
	public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
	    return new BufferedImageHttpMessageConverter();
	}
}
