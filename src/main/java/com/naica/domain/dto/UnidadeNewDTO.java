package com.naica.domain.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.naica.domain.Coordenador;
import com.naica.services.validation.UnidadeInsert;

@UnidadeInsert
public class UnidadeNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private Coordenador coordenador;
	
	private String endereco;
	
	
	public UnidadeNewDTO() {
		super();
	}

	public UnidadeNewDTO(Integer id, String nome, Coordenador coordenador, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.coordenador = coordenador;
		this.endereco = endereco;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
