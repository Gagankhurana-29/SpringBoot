package com.example.introductionToSpringBoot.firstApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FirstApplication implements CommandLineRunner {

	@Autowired
	Apple apple;

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		apple.eatApple();
	}
}
