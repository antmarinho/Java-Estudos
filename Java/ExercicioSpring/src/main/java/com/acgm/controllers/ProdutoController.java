package com.acgm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping()
	public @ResponseBody Produto novoProduto(Produto prod) {
		
		prodRepository.save(prod);
				
		return prod;
		
	}

}
