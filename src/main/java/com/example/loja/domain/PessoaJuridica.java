package com.example.loja.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("JURIDICA")
public class PessoaJuridica extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	  private String cnpj;

	  
	  public PessoaJuridica() {
		super();
	  }
	  
	  public PessoaJuridica(Integer id, String nome, String endereco, String bairro, int cep, String cidade, String estado, String cnpj) {
		    super(id, nome, endereco, bairro, cep, cidade, estado);
		    this.cnpj = cnpj;
		}

	  public String getCnpj() {
		  return cnpj;
	  }

	  public void setCnpj(String cnpj) {
		  this.cnpj = cnpj;
	  }

	  

}
