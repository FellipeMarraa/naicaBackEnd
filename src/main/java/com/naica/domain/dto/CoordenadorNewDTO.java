package com.naica.domain.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.naica.domain.Unidade;
import com.naica.services.validation.CoordenadorInsert;

@CoordenadorInsert
public class CoordenadorNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		private String nome;
		
		private String usuario;
		
		private Unidade unidade;
		
		private String email;
		
		private String senha;
		
		public CoordenadorNewDTO () {}

		public CoordenadorNewDTO (Integer id, String nome, String usuario, Unidade unidade, String email, String senha) {
			super();
			this.id = id;
			this.nome = nome;
			this.usuario = usuario;
			this.unidade = unidade;
			this.email = email;
			this.senha = senha;
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
