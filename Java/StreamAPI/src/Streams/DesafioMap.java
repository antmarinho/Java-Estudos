package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {
	
	public static void main(String[] args) {
		
		Consumer<Integer> print = System.out::println;
		
		List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		Function<Integer, String> strBinario = valor -> Integer.toBinaryString(valor); // transforma numero em string binaria
		
		UnaryOperator<String> strInvertido = str -> new StringBuilder(str).reverse().toString(); //reverter string binario
		
		Function<String, Integer> strInt = str -> Integer.parseInt(str, 2); // transforma string binario no numero
		
		
		num.stream().map(strBinario)
					.map(strInvertido)
					.map(strInt)
					.forEach(print);
					
		
	}

}
