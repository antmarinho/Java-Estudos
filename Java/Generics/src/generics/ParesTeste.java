package generics;

public class ParesTeste {
	
	public static void main(String[] args) {
		
		Pares<Integer, String> resultado = new Pares<>();
		
		resultado.adicionar(1, "Maria");
		resultado.adicionar(2, "Jose");
		resultado.adicionar(3, "Pedro");
		resultado.adicionar(4, "Ana");
		resultado.adicionar(2, "Rebeca");
		
		System.out.println(resultado.getValor(1));
		System.out.println(resultado.getValor(4));
		System.out.println(resultado.getValor(2));
		
		
	}

}
