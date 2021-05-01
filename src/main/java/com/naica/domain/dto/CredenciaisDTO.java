package com.naica.domain.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;
	
	public CredenciaisDTO() {
		super();
	}

	public CredenciaisDTO(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsername(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
