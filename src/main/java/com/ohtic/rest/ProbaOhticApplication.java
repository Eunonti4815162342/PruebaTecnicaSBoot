package com.ohtic.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohtic.rest")
public class ProbaOhticApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProbaOhticApplication.class, args);
	}

}
