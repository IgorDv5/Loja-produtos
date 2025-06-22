package com.example.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loja.domain.Compra;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
