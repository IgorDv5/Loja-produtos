package com.example.loja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.loja.domain.Pessoa;
import com.example.loja.domain.PessoaFisica;
import com.example.loja.domain.PessoaJuridica;
import com.example.loja.domain.Produto;
import com.example.loja.repositories.PessoaRepository;
import com.example.loja.repositories.ProdutoRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Produto p1 = new Produto(null, "Air Jordan", 1000, "Nike", 42, null);
		Produto p2 = new Produto(null, "Air Force", 800, "Nike", 45, null);
		Produto p3 = new Produto(null, "Revolution", 300, "Nike", 42, null);
		Produto p4 = new Produto(null, "Standart", 1000, "Adidas", 44, null);
		Produto p5 = new Produto(null, "Pro 7", 1000, "Mizuno", 38, null);
		
		PessoaJuridica pj1 = new PessoaJuridica(
			    null,
			    "Tech Solutions Ltda.",
			    "Rua da Inovação, 100",
			    "Tecnoparque",
			    12345000,
			    "São Paulo",
			    "SP",
			    "00.111.222/0001-33"
			);
			
			PessoaJuridica pj2 = new PessoaJuridica(
			    null,
			    "Comércio Digital S.A.",
			    "Avenida das Redes, 500",
			    "Bairro Central",
			    23456000,
			    "Rio de Janeiro",
			    "RJ",
			    "11.222.333/0001-44"
			);
			
			PessoaJuridica pj3 = new PessoaJuridica(
			    null,
			    "Alimentos Saudáveis EIRELI",
			    "Travessa do Sabor, 75",
			    "Vila Alimentar",
			    34567000,
			    "Belo Horizonte",
			    "MG",
			    "22.333.444/0001-55"
			);
			
			PessoaFisica pf1 = new PessoaFisica(
			    null,
			    "Ana Clara Souza",
			    "Rua da Paz, 45",
			    "Liberdade",
			    45678000,
			    "Brasília",
			    "DF",
			    "123.456.789-00",
			    "12.345.678-0"
			);
			
			PessoaFisica pf2 = new PessoaFisica(
			    null,
			    "Carlos Eduardo Lima",
			    "Avenida do Sol, 200",
			    "Nascente",
			    56789000,
			    "Curitiba",
			    "PR",
			    "987.654.321-11",
			    "98.765.432-1"
			);
			
			PessoaFisica pf3 = new PessoaFisica(
			    null,
			    "Fernanda Oliveira",
			    "Praça da Harmonia, 10",
			    "Centro Antigo",
			    67890000,
			    "Salvador",
			    "BA",
			    "456.789.123-22",
			    "45.678.912-3"
			);
			
			pessoaRepository.saveAll(Arrays.asList(pj1, pj2, pj3, pf1, pf2, pf3));
			produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

		
		
	}

}
