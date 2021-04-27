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

import com.naica.domain.Aluno;

public class ResponsavelDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String identidade;
	private Date dataEmissao;
	private String uf;
	private String orgaoExpeditor;
	private String ctps;
	private String nisResponsavel;
	private String endereco;
	private String email;
	private String observacao;
	
	@ElementCollection
	@CollectionTable(name= "TELEFONE")
	private Set<String> telefones= new HashSet<>();
	private List<Aluno> alunos= new ArrayList<>();
	
	public ResponsavelDTO() {
		super();
	}
	
	
	

	public ResponsavelDTO(Integer id, String nome, Date dataNascimento, String cpf, String identidade, Date dataEmissao,
			String uf, String orgaoExpeditor, String ctps, String nisResponsavel, String endereco, String email,
			String observacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.identidade = identidade;
		this.dataEmissao = dataEmissao;
		this.uf = uf;
		this.orgaoExpeditor = orgaoExpeditor;
		this.ctps = ctps;
		this.nisResponsavel = nisResponsavel;
		this.endereco = endereco;
		this.email = email;
		this.observacao = observacao;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
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
