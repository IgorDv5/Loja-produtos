package com.example.loja.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDateTime dataCompra;
	private double valorTotal;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Pessoa cliente;

	  @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference 
	    private List<ItemCompra> itens;

	public Compra() {
		this.dataCompra = LocalDateTime.now();
	}

	public Compra(Integer id, Pessoa cliente) {
		this.id = id;
		this.dataCompra = LocalDateTime.now();
		this.cliente = cliente;
	}

	 public void adicionarItem(ItemCompra item) {
	        this.itens.add(item);
	        item.setCompra(this);
	    }


	 public void calcularValorTotal() {
	        double total = 0.0;
	        if (this.itens != null) {
	            for (ItemCompra item : this.itens) {
	                if (Objects.nonNull(item.getPrecoUnitario()) && Objects.nonNull(item.getQuantidade())) {
	                     total += item.getPrecoUnitario() * item.getQuantidade();
	                }
	            }
	        }
	        this.valorTotal = total;
	    }

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public List<ItemCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemCompra> itens) {
		this.itens = itens;
	}

}
