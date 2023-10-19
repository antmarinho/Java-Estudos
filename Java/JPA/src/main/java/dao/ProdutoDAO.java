package dao;

import modelo.basico.Produto;

//feito por interface o DAO no lugar de classe

public class ProdutoDAO extends DAO<Produto> {
	
	public ProdutoDAO() {
		super(Produto.class);
	}

}
