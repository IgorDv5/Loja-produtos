package com.example.loja.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("FISICA")
public class PessoaFisica extends Pessoa {
	private static final long serialVersionUID = 1L;

	private String rg;
	private String cpf;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(Integer id, String nome, String endereco, String bairro, int cep, String cidade, String estado,
			String cpf, String rg, String email, String senha) {
		super(id, nome, endereco, bairro, cep, cidade, estado);
		this.cpf = cpf;
		this.rg = rg;
		this.setEmail(email);
		this.setSenha(senha);
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
