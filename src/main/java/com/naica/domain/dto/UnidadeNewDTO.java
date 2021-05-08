package com.naica.domain.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.naica.domain.Coordenador;
import com.naica.domain.Unidade;
import com.naica.services.validation.UnidadeInsert;
import org.hibernate.validator.constraints.Length;

@UnidadeInsert
public class UnidadeNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Length(min = 5, max = 80, message = "Nome deve conter entre 5 a 80 caracteres")
	@NotEmpty(message = "O campo nome não pode ser vazio")
	private String nome;
	
	private Coordenador coordenador;
	
	private String endereco;
	
	
	public UnidadeNewDTO() {
		super();
	}

	public UnidadeNewDTO(Unidade unidade) {
		super();
		this.id = unidade.getId();
		this.nome = unidade.getNome();
		this.coordenador = unidade.getCoordenador();
		this.endereco = unidade.getEndereco();
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
