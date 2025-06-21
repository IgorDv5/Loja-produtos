package com.example.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loja.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
