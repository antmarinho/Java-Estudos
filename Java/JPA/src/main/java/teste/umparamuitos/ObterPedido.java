package teste.umparamuitos;

import dao.DAO;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class ObterPedido {
	
	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<Pedido>(Pedido.class);
		
		Pedido pedido = dao.obterPorID(1L);
		
		for(ItemPedido item: pedido.getItens()) {
			
			System.out.println(item.getQtd());
			System.out.println(item.getProduto().getNome());
			
		}
		
		dao.fechar();
		
	}

}
