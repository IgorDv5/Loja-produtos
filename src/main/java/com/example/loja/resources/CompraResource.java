package com.example.loja.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.loja.domain.Compra;
import com.example.loja.services.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraResource { 
	
	@Autowired
    private CompraService compraService;
  
	 @PostMapping
	    public ResponseEntity<Compra> createCompra(@RequestBody Compra compra) { // << Recebe a ENTIDADE Compra
	        // A entidade 'compra' já virá preenchida pelo Jackson com os dados do JSON.
	        // O Service fará a busca das entidades relacionadas (cliente, produto) pelo ID.
	        Compra newCompra = compraService.createCompra(compra);
	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}").buildAndExpand(newCompra.getId()).toUri();
	        return ResponseEntity.created(uri).body(newCompra);
	    }
	    
	    @GetMapping(value = "/{id}")
	    public ResponseEntity<Compra> findById(@PathVariable Integer id) {
	        Compra obj = compraService.findById(id);
	        return ResponseEntity.ok().body(obj);
	    }

	    @GetMapping
	    public ResponseEntity<List<Compra>> findAll() {
	        List<Compra> list = compraService.findAll();
	        return ResponseEntity.ok().body(list);
	    }

}
