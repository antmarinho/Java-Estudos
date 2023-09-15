package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map {
	
	public static void main(String[] args) {
		
		Consumer<String> print = System.out::println;
		
		List<String> marcas  = Arrays.asList("bmw ", "audi ", "ford");
		
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		
		UnaryOperator<String> maiuscula = n -> n.toUpperCase();
		UnaryOperator<String> minuscula = n -> n.toLowerCase();
		UnaryOperator<String> primLetra = n -> n.substring(0, 1);
		
		//usando composicao
		marcas.stream().map(maiuscula)
					   .map(primLetra)
					   .map(minuscula)
					   .forEach(print);
		
	}

}
