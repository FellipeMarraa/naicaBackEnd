package com.naica.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.naica.domain.Aluno;
import com.naica.domain.Responsavel;
import com.naica.services.validation.ResponsavelUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@ResponsavelUpdate
public class ResponsavelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 5, max = 80, message = "Nome deve conter entre 5 a 80 caracteres")
//    @NotEmpty(message = "O campo nome não pode ser vazio")
    private String nome;

//    @NotEmpty(message = "O campo data de emissão não pode ser vazio")
    private Date dataEmissao;

//    @NotEmpty(message = "O campo uf não pode ser vazio")
    private String uf;

//    @NotEmpty(message = "O campo orgao expeditor não pode ser vazio")
    private String orgaoExpeditor;

    private String ctps;

    private String nisResponsavel;

//    @NotEmpty(message = "O campo endereço não pode ser vazio")
    private String endereco;

    @Email
    private String email;

    private String observacao;

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
//    @NotEmpty(message = "O campo telefone não pode ser vazio")
    private Set<String> telefones = new HashSet<>();

//    @NotEmpty(message = "O campo atendido(s) não pode ser vazio")
    private List<Aluno> alunos = new ArrayList<>();

    public ResponsavelDTO() {
        super();
    }

    public ResponsavelDTO(Responsavel responsavel) {
        super();
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
        this.dataEmissao = responsavel.getDataEmissao();
        this.uf = responsavel.getUf();
        this.orgaoExpeditor = responsavel.getOrgaoExpeditor();
        this.ctps = responsavel.getCtps();
        this.nisResponsavel = responsavel.getNisResponsavel();
        this.endereco = responsavel.getEndereco();
        this.email = responsavel.getEmail();
        this.observacao = responsavel.getObservacao();
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
    
    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getNisResponsavel() {
        return nisResponsavel;
    }

    public void setNisResponsavel(String nisResponsavel) {
        this.nisResponsavel = nisResponsavel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    public List<Aluno> getAlunos() {
        return alunos;
    }


    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }


    public Set<String> getTelefones() {
        return telefones;
    }


    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }


}
