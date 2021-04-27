package com.naica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naica.domain.Coordenador;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer> {
}