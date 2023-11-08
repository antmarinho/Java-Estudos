package com.acgm.model.entities.repositories;

import org.springframework.data.repository.CrudRepository;
import com.acgm.model.entities.Produto;

public interface ProdutosRepository extends CrudRepository<Produto,Integer> {
	
	

}
