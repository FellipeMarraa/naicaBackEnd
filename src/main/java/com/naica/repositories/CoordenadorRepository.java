package com.naica.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naica.domain.Coordenador;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer> {

	@Transactional
	Coordenador findByEmail(String email);

	@Transactional
	Coordenador findByNome(String nome);
}