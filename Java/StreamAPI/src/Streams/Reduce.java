package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce {
	
	public static void main(String[] args) {
		
		List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		BinaryOperator<Integer> soma = (ac,n) -> ac + n;
		
		
		//get n e opcional e um inteiro
		int total = num.stream().reduce(soma).get();
						
		System.out.println(total); 
		
		//se passar valor tem vem inteiro
		Integer tot = num.stream().reduce(100,soma);
		
		System.out.println(tot);
		
		
		//opcional de inteiro
		num.stream().filter(n -> n > 5)
				    .reduce(soma)
				    .ifPresent(System.out::println);
		
	}

}
 

