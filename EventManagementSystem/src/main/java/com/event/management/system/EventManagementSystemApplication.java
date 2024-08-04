package com.event.management.system;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);
		
		System.out.println("Project started!!!!");
	}

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
