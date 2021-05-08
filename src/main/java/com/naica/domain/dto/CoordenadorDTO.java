package com.naica.domain.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.naica.domain.Coordenador;
import com.naica.domain.Unidade;
import com.naica.services.validation.CoordenadorUpdate;
import org.hibernate.validator.constraints.Length;

@CoordenadorUpdate
public class CoordenadorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Length(min = 5, max = 80, message = "Nome deve conter entre 5 a 80 caracteres")
	@NotEmpty(message = "O campo nome não pode ser vazio")
	private String nome;

	private String usuario;

	@NotEmpty(message = "O campo email não pode ser vazio")
	@Email
	private String email;

	@NotEmpty(message = "O campo senha não pode ser vazio")
	private String senha;

	private Unidade unidade;
	
	public CoordenadorDTO () {}

	public CoordenadorDTO (Coordenador coordenador) {
		super();
		this.id = coordenador.getId();
		this.nome = coordenador.getNome();
		this.usuario = coordenador.getUsuario();
		this.unidade = coordenador.getUnidade();
		this.email = coordenador.getEmail();
		this.senha = coordenador.getSenha();
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
