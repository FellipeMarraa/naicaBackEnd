package com.naica.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naica.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer>{

	@Transactional 
	Aluno findByNome(String nome);

	
	
}
