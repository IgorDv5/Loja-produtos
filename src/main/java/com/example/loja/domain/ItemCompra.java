package com.example.loja.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer quantidade;
	private double precoUnitario; 

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	 @ManyToOne
	    @JoinColumn(name = "compra_id") // Coluna que faz a ligação com a Compra no banco
	    // ONDE VAI A SOLUÇÃO: @JsonBackReference
	    @JsonBackReference // Esta anotação diz ao Jackson para IGNORAR esta referência de volta para Compra
	    private Compra compra;

	public ItemCompra() {
		super();
	}

	public ItemCompra(Integer id, Integer quantidade, double precoUnitario, Produto produto, Compra compra) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.produto = produto;
		this.compra = compra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}
