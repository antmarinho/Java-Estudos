package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {
	
	public static void main(String[] args) {
		
		Produto p1 = new Produto("lapis", 1.99, 0.35, 0);
		Produto p2 = new Produto("notebook", 4899.89, 0.32, 0);
		Produto p3 = new Produto("caderno", 30, 0.45, 0);
		Produto p4 = new Produto("impressora", 1200, 0.40, 0);
		Produto p5 = new Produto("ipda", 3100, 0.29, 0);
		Produto p6 = new Produto("monitor", 800, 0.31, 0);
		
		List<Produto> prod = Arrays.asList(p1,p2,p3,p4,p5,p6);
		
		Predicate<Produto> suprePromo = p -> p.desconto >= 0.30;
		Predicate<Produto> freteGratis = p -> p.valorFrete == 0;
		Predicate<Produto> prodRele = p -> p.preco >= 500;
		
		Function<Produto, String> chamadaPromo = p-> "aproveite frete gratis " + p.nome + " por R$ " + p.preco;
		
		prod.stream().filter(suprePromo)
					 .filter(freteGratis)
					 .filter(prodRele)
					 .map(chamadaPromo)
					 .forEach(System.out::println);
		
		
	}

}
