package com.example.loja.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loja.domain.Compra;
import com.example.loja.domain.ItemCompra;
import com.example.loja.domain.Pessoa;
import com.example.loja.domain.Produto;
import com.example.loja.repositories.CompraRepository;

import jakarta.transaction.Transactional;

@Service
public class CompraService {


    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private PessoaService pessoaService; // Para buscar o cliente

    @Autowired
    private ProdutoService produtoService; // Para buscar o produto

	 @Transactional
	    public Compra createCompra(Compra compra) { // << Recebe a ENTIDADE Compra diretamente
	        // Validações básicas antes de processar
	        if (compra.getCliente() == null || compra.getCliente().getId() == null) {
	            throw new IllegalArgumentException("Cliente é obrigatório para a compra.");
	        }
	        if (compra.getItens() == null || compra.getItens().isEmpty()) {
	            throw new IllegalArgumentException("A compra deve ter pelo menos um item.");
	        }

	        // 1. Define a data da compra (se não vier no JSON)
	        if (compra.getDataCompra() == null) {
	            compra.setDataCompra(LocalDateTime.now());
	        }
	        
	        // 2. Busca o cliente real do banco de dados
	        // A entidade Compra já virá com o objeto 'cliente' preenchido pelo Jackson,
	        // mas este 'cliente' terá apenas o 'id' e '@type' do JSON.
	        // Precisamos buscar a instância gerenciada pelo JPA.
	        Pessoa clienteGerenciado = pessoaService.findById(compra.getCliente().getId());
	        compra.setCliente(clienteGerenciado);

	        // 3. Processar os itens da compra
	        List<ItemCompra> itensProcessados = new ArrayList<>();
	        for (ItemCompra itemRecebido : compra.getItens()) {
	            // Validações para o item
	            if (itemRecebido.getProduto() == null || itemRecebido.getProduto().getId() == null) {
	                throw new IllegalArgumentException("ID do produto é obrigatório para um item da compra.");
	            }
	            if (itemRecebido.getQuantidade() == null || itemRecebido.getQuantidade() <= 0) {
	                throw new IllegalArgumentException("Quantidade deve ser maior que zero para um item da compra.");
	            }

	            Produto produtoGerenciado = produtoService.findById(itemRecebido.getProduto().getId()); 
	            
	            // Cria um novo ItemCompra para garantir que está gerenciado corretamente
	            ItemCompra itemNovo = new ItemCompra();
	            itemNovo.setProduto(produtoGerenciado); 
	            itemNovo.setQuantidade(itemRecebido.getQuantidade());
	            itemNovo.setPrecoUnitario(produtoGerenciado.getPreco()); // Pega o preço atual do Produto
	            itemNovo.setCompra(compra); // Associa o item à compra para a relação bidirecional
	            
	            itensProcessados.add(itemNovo);
	        }
	        compra.setItens(itensProcessados); // Define a lista de itens processados

	        // 4. Calcular o valor total da compra
	        compra.calcularValorTotal(); // Este método já foi ajustado para double, null

	        // 5. Salvar a compra (e os itens serão salvos em cascata devido ao CascadeType.ALL)
	        return compraRepository.save(compra);
	    }
	    
	 
	    public Compra findById(Integer id) {
	        Optional<Compra> obj = compraRepository.findById(id);
	        return obj.orElseThrow(() -> new RuntimeException("Compra não encontrada! ID: " + id));
	    }
	    

	    public List<Compra> findAll() {
	        return compraRepository.findAll();
	    }
	} 


