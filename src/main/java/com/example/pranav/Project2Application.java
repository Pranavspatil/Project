package com.example.pranav;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;


@SpringBootApplication
@EnableSpringConfigured
public class Project2Application   {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Project2Application.class, args);
	
	}



}
