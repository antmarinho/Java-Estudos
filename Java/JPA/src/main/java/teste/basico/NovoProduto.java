package teste.basico;

import dao.DAO;
import modelo.basico.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		Produto prod = new Produto("monitor 23", 852.75);
		
		//dao.abrirT().incluir(prod).fecharT().fechar();
		
		dao.incluirAtomico(prod).fechar();
		
		System.out.println("id " + prod.getId());
		
	}

}
