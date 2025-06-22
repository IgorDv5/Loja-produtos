package com.example.loja.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loja.domain.Produto;
import com.example.loja.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public Produto findById(Integer id) {
        Optional<Produto> obj = repository.findById(id);
      
        return obj.orElseThrow(() -> new RuntimeException("Produto não encontrado! ID: " + id)); 
    }
	
	public List<Produto> findAll(){
		return repository.findAll();
	}

	public Produto create(Produto produto) {
		produto.setId(null); 
	    return repository.save(produto);
	}
	
	public Produto update(Produto produto) {
	    Produto existingObj = findById(produto.getId());

	    if (existingObj == null) {
	        throw new RuntimeException("Produto não encontrado para atualização. ID: " + produto.getId());
	    }

	    BeanUtils.copyProperties(produto, existingObj, "id");

	    if (existingObj.getPreco() < 0) {
	        throw new IllegalArgumentException("Preço do produto não pode ser negativo na atualização.");
	    }

	    return repository.save(existingObj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}
