package Composicao.UmParaMuitos;

public class CompraTeste {

	public static void main(String[] args) {
		
		Compra c = new Compra();
		
		c.cliente = "jose";
		c.adicionarItem("caneta", 20, 7.5);
		c.adicionarItem("borracha", 10, 2.4);
		c.adicionarItem("caderno", 2, 21.8);
		c.adicionarItem("lapis", 5, 1.50);
		
		System.out.println(c.itens.size());
		System.out.println(c.valorTotal());
	
	}
}
