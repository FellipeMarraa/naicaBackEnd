package com.naica.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naica.service.ResponsavelService;

@RestController
@RequestMapping(value="/responsaveis")
public class ResponsavelResource {
	
	@Autowired
	private ResponsavelService service;
}