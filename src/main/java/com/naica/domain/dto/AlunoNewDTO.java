package com.naica.domain.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naica.domain.Responsavel;
import com.naica.domain.Unidade;
import com.naica.services.validation.AlunoInsert;

@AlunoInsert
public class AlunoNewDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Unidade unidade;
	private Date dataNascimento;
	private Integer idadeAtual;
	private Integer idadeInicial;
	private String sexo;
	private String nisAtendido;
	private Date dataMatricula;
	private boolean desligado;
	private String escola;
	private String anoEscolar;
	private String periodoEscolar;
	private boolean desacompanhado;
	private String autorizadoBuscar;
	
	private List<Responsavel> responsaveis;
	
	
	public AlunoNewDTO() {
		super();
	}


	public AlunoNewDTO(Integer id, String nome, Unidade unidade, Date dataNascimento, Integer idadeAtual,
			Integer idadeInicial, String sexo, String nisAtendido, Date dataMatricula, boolean desligado, String escola,
			String anoEscolar,String periodoEscolar , boolean desacompanhado, String autorizadoBuscar) {
		super();
		
		this.id = id;
		this.nome = nome;
		this.unidade = unidade;
		this.dataNascimento = dataNascimento;
		this.idadeAtual = idadeAtual;
		this.idadeInicial = idadeInicial;
		this.sexo = sexo;
		this.nisAtendido = nisAtendido;
		this.dataMatricula = dataMatricula;
		this.desligado = desligado;
		this.escola = escola;
		this.anoEscolar = anoEscolar;
		this.periodoEscolar = periodoEscolar;
		this.desacompanhado = desacompanhado;
		this.autorizadoBuscar = autorizadoBuscar;
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


	public Unidade getUnidade() {
		return unidade;
	}


	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Integer getIdadeAtual() {
		return idadeAtual;
	}


	public void setIdadeAtual(Integer idadeAtual) {
		this.idadeAtual = idadeAtual;
	}


	public Integer getIdadeInicial() {
		return idadeInicial;
	}


	public void setIdadeInicial(Integer idadeInicial) {
		this.idadeInicial = idadeInicial;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getNisAtendido() {
		return nisAtendido;
	}


	public void setNisAtendido(String nisAtendido) {
		this.nisAtendido = nisAtendido;
	}


	public Date getDataMatricula() {
		return dataMatricula;
	}


	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}


	public boolean isDesligado() {
		return desligado;
	}


	public void setDesligado(boolean desligado) {
		this.desligado = desligado;
	}


	public String getEscola() {
		return escola;
	}


	public void setEscola(String escola) {
		this.escola = escola;
	}


	public String getAnoEscolar() {
		return anoEscolar;
	}


	public void setAnoEscolar(String anoEscolar) {
		this.anoEscolar = anoEscolar;
	}

	
	public String getPeriodoEscolar() {
		return periodoEscolar;
	}


	public void setPeriodoEscolar(String periodoEscolar) {
		this.periodoEscolar = periodoEscolar;
	}


	public boolean isDesacompanhado() {
		return desacompanhado;
	}


	public void setDesacompanhado(boolean desacompanhado) {
		this.desacompanhado = desacompanhado;
	}


	public String getAutorizadoBuscar() {
		return autorizadoBuscar;
	}


	public void setAutorizadoBuscar(String autorizadoBuscar) {
		this.autorizadoBuscar = autorizadoBuscar;
	}

	
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}


	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoNewDTO other = (AlunoNewDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
