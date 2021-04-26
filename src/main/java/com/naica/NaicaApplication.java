package com.naica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NaicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaicaApplication.class, args);
		
		System.out.println("BANCO RODANDO");
	}

}
