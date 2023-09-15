package Streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ListIteratorStream {
	
	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("joao","maria","jose");
		
		for(String nome: aprovados){
			
			System.out.println(nome);
			
		}
		
		Iterator<String> it = aprovados.iterator(); 
		
		while(it.hasNext()){
			
			System.out.println(it.next());
			
		}
		
		Stream<String> stream = aprovados.stream();
		stream.forEach(System.out::println);
		
	}

}
