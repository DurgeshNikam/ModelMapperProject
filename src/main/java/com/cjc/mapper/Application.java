package com.cjc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Application Running..!");
	}
	
	@Bean
	public ModelMapper getModelmapper()
	{
		
		return new ModelMapper();
	}

}
