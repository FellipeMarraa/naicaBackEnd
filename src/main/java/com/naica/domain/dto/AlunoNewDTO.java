package com.naica.domain.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.naica.domain.Aluno;
import com.naica.domain.Responsavel;
import com.naica.domain.Unidade;
import com.naica.services.validation.AlunoInsert;

@AlunoInsert
public class AlunoNewDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
////	@NotEmpty(message = "O campo nome não pode ser vazio")
	private String nome;
//	@NotEmpty(message = "O campo data de nascimento não pode ser vazio")
	private Date dataNascimento;
//	@NotEmpty(message = "O campo idade atual não pode ser vazio")
	private Integer idadeAtual;
//	@NotEmpty(message = "O campo idade inicial não pode ser vazio")
	private Integer idadeInicial;
//	@NotEmpty(message = "O campo sexo não pode ser vazio")
	private String sexo;

	private String nisAtendido;
//	@NotEmpty(message = "O campo data de matrícula não pode ser vazio")
	private Date dataMatricula;

	private boolean desligado;
//	@NotEmpty(message = "O campo escola não pode ser vazio")
	private String escola;
//	@NotEmpty(message = "O campo ano escolar não pode ser vazio")
	private String anoEscolar;
//	@NotEmpty(message = "O campo período escolar não pode ser vazio")
	private String periodoEscolar;
//	@NotEmpty(message = "O campo desacompanhado não pode ser vazio")
	private boolean desacompanhado;

	private String autorizadoBuscar;

//	@NotEmpty(message = "O campo responsável(is) não pode ser vazio")
	private Responsavel responsavel;

//	@NotEmpty(message = "O campo unidade não pode ser vazio")
	private Unidade unidade;
	
	
	public AlunoNewDTO() {
		super();
	}

	public AlunoNewDTO(Aluno aluno) {
		super();
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.unidade = aluno.getUnidade();
		this.dataNascimento = aluno.getDataNascimento();
		this.idadeAtual = getIdadeAtual();
		this.idadeInicial = getIdadeInicial();
		this.sexo = aluno.getSexo();
		this.nisAtendido = aluno.getNisAtendido();
		this.dataMatricula = aluno.getDataMatricula();
		this.desligado = aluno.isDesligado();
		this.escola = aluno.getEscola();
		this.anoEscolar = aluno.getAnoEscolar();
		this.periodoEscolar = aluno.getPeriodoEscolar();
		this.desacompanhado = aluno.isDesacompanhado();
		this.autorizadoBuscar = aluno.getAutorizadoBuscar();
		this.responsavel = aluno.getResponsavel();
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


	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
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
