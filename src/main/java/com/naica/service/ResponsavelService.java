package com.naica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naica.domain.Responsavel;
import com.naica.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	
	@Autowired
	private ResponsavelRepository repository;
	
}
