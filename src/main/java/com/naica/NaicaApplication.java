package com.naica;

import com.naica.domain.Coordenador;
import com.naica.domain.Unidade;
import com.naica.repositories.CoordenadorRepository;
import com.naica.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class NaicaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NaicaApplication.class, args);
		
		System.out.println("BANCO RODANDO");
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
