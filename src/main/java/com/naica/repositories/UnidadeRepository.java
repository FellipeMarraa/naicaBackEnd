package com.naica.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naica.domain.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

	@Transactional
	Unidade findByNome(String nome);
}
