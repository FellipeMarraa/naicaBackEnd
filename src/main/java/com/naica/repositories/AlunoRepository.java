package com.naica.repositories;

import javax.transaction.Transactional;

import com.naica.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

import com.naica.domain.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno,Integer>{

	@Transactional 
	Aluno findByNome(String nome);


}
