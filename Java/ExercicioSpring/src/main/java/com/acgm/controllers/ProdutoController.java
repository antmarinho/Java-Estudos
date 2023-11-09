package com.acgm.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.acgm.model.entities.Produto;
import com.acgm.model.entities.repositories.ProdutosRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutosRepository prodRepository;
	
	//@PostMapping
	// inserir e editar
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public @ResponseBody Produto salvarProdutoa(@Valid Produto prod) {
		
		prodRepository.save(prod);
				
		return prod;
		
	}
	
	@GetMapping
	public Iterable<Produto> obterProdutos() {
		
		return prodRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) {
		
		return prodRepository.searchByNameLike(parteNome);
		
		//return prodRepository.findByNomeContainingIgnoreCase(parteNome);
	}
	
	//consulta paginada
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina, @PathVariable int qtdPagina) {
		
		if(qtdPagina >= 5)
			qtdPagina = 5;
		
		Pageable page = PageRequest.of(numeroPagina, qtdPagina);
		
		return prodRepository.findAll(page);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		
		return prodRepository.findById(id);
	}
	
	/*@PutMapping editar separado
	public Produto alterarProduto(@Valid Produto prod) {
		
		prodRepository.save(prod);
		
		return prod;
		
	}*/
	
	@DeleteMapping(path = "/{id}")
	public void excluirProduto(@PathVariable int id) {
		
		prodRepository.deleteById(id);
		
	}

}
