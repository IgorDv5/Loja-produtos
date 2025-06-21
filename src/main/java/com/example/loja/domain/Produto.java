package com.example.loja.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	 
	@NotNull
	private String nome; 
	
	private double preco; 
	@NotNull
	private String Marca; 
	private Integer tamanho; 
	
	private Integer quantidade;
	
	@Lob
	private byte[] foto;
	

	public Produto() {
		super();
	}

	

	public Produto(Integer id, @NotNull String nome, double preco, @NotNull String marca, Integer tamanho,
			Integer quantidade, byte[] foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		Marca = marca;
		this.tamanho = tamanho;
		this.quantidade = quantidade;
		this.foto = foto;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}



	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

		

}
