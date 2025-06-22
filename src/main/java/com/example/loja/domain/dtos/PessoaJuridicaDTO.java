package com.example.loja.domain.dtos;

import java.io.Serializable;

import com.example.loja.domain.PessoaJuridica;

public class PessoaJuridicaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	  	private Integer id;
	    private String nome;
	    private String endereco;
	    private String bairro;
	    private Integer cep;
	    private String cidade;
	    private String estado;
	    private String cnpj; 
	    
	    private String type = "JURIDICA";
	    
		public PessoaJuridicaDTO() {
			super();
		}

		public PessoaJuridicaDTO(PessoaJuridica obj) {
			super();
			this.id = obj.getId();
			this.nome = obj.getNome();
			this.endereco = obj.getEndereco();
			this.bairro = obj.getBairro();
			this.cep = obj.getCep();
			this.cidade = obj.getCidade();
			this.estado = obj.getEstado();
			this.cnpj = obj.getCnpj();
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

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
	    
		  public String getType() {
			  return type; 
			  }

}
