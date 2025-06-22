package com.example.loja.domain.dtos;

import java.io.Serializable;

import com.example.loja.domain.PessoaFisica;

import jakarta.validation.constraints.NotBlank;

public class PessoaFisicaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	

    private Integer id;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    private String endereco;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String estado;
    private String cpf;
    private String rg;
    
    private String type = "FISICA";
    
	public PessoaFisicaDTO() {
		super();
	}

	public PessoaFisicaDTO(PessoaFisica obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.endereco = obj.getEndereco();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.cpf = obj.getCpf();
		this.rg= obj.getRg();
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	 public String getType() {
		 return type;
		 }
    
}
