package com.acgm.model.entities.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.acgm.model.entities.Produto;

//public interface ProdutosRepository extends CrudRepository<Produto,Integer> {
	
public interface ProdutosRepository extends PagingAndSortingRepository<Produto,Integer> {	

	//o spring vai implementar sozinho
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	//findByNomeContaining
	//findByNomeIsContaining
	//findByNomeContains
	
	//faz a msm coisa
	
	//findByNomeStartsWith    
	//findByNomeEndsWith
	//findByNomeNotContaining
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
	
}
