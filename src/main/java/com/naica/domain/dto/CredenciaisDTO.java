package com.naica.domain.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String senha;
	
	public CredenciaisDTO() {
		super();
	}

	public CredenciaisDTO(String username, String senha) {
		super();
		this.username = username;
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
