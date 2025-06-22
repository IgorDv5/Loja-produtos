package com.example.loja.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.loja.domain.Pessoa;
import com.example.loja.domain.PessoaFisica;
import com.example.loja.domain.PessoaJuridica;
import com.example.loja.domain.dtos.PessoaFisicaDTO;
import com.example.loja.domain.dtos.PessoaJuridicaDTO;
import com.example.loja.services.PessoaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
	
	 @Autowired
	 private PessoaService service;
	 
	  @GetMapping(value = "/{id}")
	    public ResponseEntity<Object> findById(@PathVariable Integer id) {
	        Pessoa obj = service.findById(id); 
	        
	        if (obj instanceof PessoaFisica) {
	            return ResponseEntity.ok().body(new PessoaFisicaDTO((PessoaFisica) obj));
	        } else if (obj instanceof PessoaJuridica) {
	            return ResponseEntity.ok().body(new PessoaJuridicaDTO((PessoaJuridica) obj));
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tipo de pessoa desconhecido.");
	    }
	  
	  @GetMapping
	    public ResponseEntity<List<Object>> findAll() {
	        List<Pessoa> list = service.findAll();
	        
	        List<Object> listDTO = list.stream()
	                                   .map(pessoa -> {
	                                       if (pessoa instanceof PessoaFisica) {
	                                           return new PessoaFisicaDTO((PessoaFisica) pessoa);
	                                       } else if (pessoa instanceof PessoaJuridica) {
	                                           return new PessoaJuridicaDTO((PessoaJuridica) pessoa);
	                                       }
	                                       return null; 
	                                   })
	                                   .filter(java.util.Objects::nonNull) 
	                                   .collect(Collectors.toList());
	        return ResponseEntity.ok().body(listDTO);
	    }
	

	  
	  @PostMapping(value = "/fisica")
	    public ResponseEntity<PessoaFisica> createPessoaFisica(@Valid @RequestBody PessoaFisicaDTO dto) {
		  PessoaFisica newObj = service.createPessoaFisica(dto);
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
	        return ResponseEntity.created(uri).body(newObj);
	    }
	  
	  @PostMapping(value = "/juridica")
	    public ResponseEntity<PessoaJuridica> createPessoaJuridica(@Valid @RequestBody PessoaJuridicaDTO dto) {
	        PessoaJuridica newObj = service.createPessoaJuridica(dto);
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
	        return ResponseEntity.created(uri).body(newObj);
	    }
	
	  
	  @PutMapping(value = "/fisica/{id}")
	    public ResponseEntity<PessoaFisica> updatePessoaFisica(@PathVariable Integer id, @Valid @RequestBody PessoaFisicaDTO dto) {
	        PessoaFisica updatedObj = service.updatePessoaFisica(id, dto);
	        return ResponseEntity.ok().body(updatedObj);
	    }
  
	    @PutMapping(value = "/juridica/{id}")
	    public ResponseEntity<PessoaJuridica> updatePessoaJuridica(@PathVariable Integer id, @Valid @RequestBody PessoaJuridicaDTO dto) {
	        PessoaJuridica updatedObj = service.updatePessoaJuridica(id, dto);
	        return ResponseEntity.ok().body(updatedObj);
	    }

	 

	    @DeleteMapping(value = "/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();
	    }  
	}    
    