package Predicate;

import java.util.function.Predicate;

public class Predicado {  // recebe um argumento e retorna um booleano
	
	public static void main(String[] args) {
		
		Predicate<Produto> isCaro = prod -> (prod.preco * (1 - prod.desconto)) >= 750;
		
		Produto produto = new Produto("not", 3000, 0.15);
		
		System.out.println(isCaro.test(produto));
		
	}

}
