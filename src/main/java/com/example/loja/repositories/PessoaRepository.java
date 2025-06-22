package com.example.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loja.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	 Pessoa findByEmail(String email);

}
