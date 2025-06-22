package com.example.loja.resources;



import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.loja.domain.Produto;
import com.example.loja.services.ProdutoService;


@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
 	public ResponseEntity<List<Produto>> findAll(){
 		List<Produto> list = service.findAll();
 		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto obj){
		Produto newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable Integer id,@RequestBody Produto obj){
		 obj.setId(id);
		 Produto updatedObj = service.update(obj);
		 return ResponseEntity.ok().body(updatedObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Produto> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
