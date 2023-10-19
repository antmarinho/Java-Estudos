package teste.basico;

import java.util.List;
import dao.ProdutoDAO;
import modelo.basico.Produto;

public class ObterProdutos {
	
	public static void main(String[] args) {
		
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> prod = dao.obterTodos();
		
		for(Produto produto: prod)
			System.out.println("id: " + produto.getId() + " Nome: " + produto.getNome() + " Preco: R$ " + produto.getPreco());
		
		double precoTotal = prod.stream()
								.map(p -> p.getPreco())
								.reduce(0.0, (t,p) -> t + p)
								.doubleValue();
		
		System.out.println("o valor total e R$ " + precoTotal);
		
		dao.fechar();
		
	}

}
