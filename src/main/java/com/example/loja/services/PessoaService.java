package com.example.loja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loja.domain.Pessoa;
import com.example.loja.domain.PessoaFisica;
import com.example.loja.domain.PessoaJuridica;
import com.example.loja.domain.dtos.PessoaFisicaDTO;
import com.example.loja.domain.dtos.PessoaJuridicaDTO;
import com.example.loja.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	

	 public Pessoa findById(Integer id) { 
		 Optional<Pessoa> obj = repository.findById(id);
	     return obj.orElseThrow(() -> new RuntimeException("Pessoa não encontrada! ID: " + id));
	    }
	 
	 public List<Pessoa> findAll() {
		 return repository.findAll();
	    }

	 public PessoaFisica createPessoaFisica(PessoaFisicaDTO dto) {
		 PessoaFisica pessoa = new PessoaFisica();
		 BeanUtils.copyProperties(dto, pessoa);
		 pessoa.setId(null);
		 return repository.save(pessoa);
	    }
	 
	 public PessoaJuridica createPessoaJuridica(PessoaJuridicaDTO dto) {
		 PessoaJuridica pessoa = new PessoaJuridica();
		 BeanUtils.copyProperties(dto, pessoa);
		 pessoa.setId(null);
		 return repository.save(pessoa);
	    }
	 
	 public PessoaFisica updatePessoaFisica(Integer id,PessoaFisicaDTO dto) {
		 Pessoa existPessoa = findById(id);
		 
		 if (!(existPessoa instanceof PessoaFisica)) {
	            throw new IllegalArgumentException("O ID " + id + " não corresponde a uma Pessoa Física.");
	        }
		  PessoaFisica existPessoaFisica = (PessoaFisica) existPessoa;
		  BeanUtils.copyProperties(dto, existPessoaFisica, "id");
		  return repository.save(existPessoaFisica);
	 }
	 
	 public PessoaJuridica updatePessoaJuridica(Integer id,PessoaJuridicaDTO dto) {
		 Pessoa existPessoa = findById(id);
		 
		 if (!(existPessoa instanceof PessoaJuridica)) {
	            throw new IllegalArgumentException("O ID " + id + " não corresponde a uma Pessoa Física.");
	        }
		 
		  PessoaJuridica existPessoaJuridica = (PessoaJuridica) existPessoa;
		  
		  BeanUtils.copyProperties(dto, existPessoaJuridica, "id");
		  
		  return repository.save(existPessoaJuridica);
	 }
	 
	 
	 public void delete(Integer id) {
	        repository.findById(id); 
	        repository.deleteById(id);
	    }
	 
}