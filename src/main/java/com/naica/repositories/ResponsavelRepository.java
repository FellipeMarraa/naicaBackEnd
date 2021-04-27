package com.naica.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naica.domain.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {

	@Transactional
	Responsavel findByNome(String nome);

}
