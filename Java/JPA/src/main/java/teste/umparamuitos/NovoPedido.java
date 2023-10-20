package teste.umparamuitos;

import dao.DAO;
import modelo.basico.Produto;
import modelo.umparamuitos.ItemPedido;
import modelo.umparamuitos.Pedido;

public class NovoPedido {
	
	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<Object>();
		
		Produto prod = new Produto("geladeira", 3548.56);
		
		Pedido pedido = new Pedido();
		
		ItemPedido item = new ItemPedido(10, pedido, prod);
		
		dao.abrirT()
		   .incluir(prod)
		   .incluir(pedido)
		   .incluir(item)
		   .fecharT()
		   .fechar();
		
		
	}
	
	
}
