package Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import Predicate.Produto;

public class Consumidor { // recebe argumento e n retorna nada
	
	public static void main(String[] args) {
		

		Consumer<Produto> impr = p -> System.out.println(p.nome);
		
		Produto produto = new Produto("caneta", 10, 0);
		
		impr.accept(produto);
		
		Produto p1 = new Produto("caneta", 10, 0);
		Produto p2 = new Produto("caneta", 10, 0);
		Produto p3 = new Produto("caneta", 10, 0);
		Produto p4 = new Produto("caneta", 10, 0);
		Produto p5 = new Produto("caneta", 10, 0);
		
		List<Produto> produ = Arrays.asList(p1,p2,p3,p4,p5);
		
		produ.forEach(impr);
		
	}

}
