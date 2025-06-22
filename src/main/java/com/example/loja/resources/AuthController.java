package com.example.loja.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja.domain.Pessoa;
import com.example.loja.domain.dtos.LoginDTO;
import com.example.loja.services.PessoaService;

@RestController
@RequestMapping(value = "/login")
public class AuthController {

	@Autowired
	private PessoaService service;

	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		Pessoa pessoa = service.findByEmail(loginDTO.getEmail());

		if (pessoa != null && pessoa.getSenha().equals(loginDTO.getSenha())) {
			return ResponseEntity.ok("Login efetuado com sucesso para: " + pessoa.getNome());
		} else {
			return ResponseEntity.status(401).body("Email ou senha inválidos.");
		}
	}

}
