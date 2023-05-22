package Lambda;

import java.util.Arrays;
import java.util.List;

public class Foreach {
	
	static void imprimir(String nome) {
		
		System.out.println("oi meu nome e " + nome);
		
	}
	
	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("ana","joao","jose");
		
		//forma tradicional
		for(String nome: aprovados) {
			
			System.out.println(nome);
		}
		
		//forma lambda
		aprovados.forEach((nome) -> {System.out.println(nome);});
		
		//foreach referencia
		aprovados.forEach(System.out::println);
		
		//lambda2
		aprovados.forEach(nome -> imprimir(nome));
		
		//referencia2
		aprovados.forEach(Foreach::imprimir);
	
	}
	
}
