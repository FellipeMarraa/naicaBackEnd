package com.naica.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {

    private String username;

    private String senha;

    public CredenciaisDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setCpf(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
