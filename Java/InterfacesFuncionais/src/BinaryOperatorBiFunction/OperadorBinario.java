package BinaryOperatorBiFunction;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {
	
	public static void main(String[] args) {
		
		//recebe 2 tipo
		BinaryOperator<Double> media = (n1,n2) -> ((n1+n2)/2);
		
		System.out.println(media.apply(8.1, 5.2));
		
		//recebe 2 e retorna 1 tipo
		BiFunction<Double, Double, String> resultado = (n1,n2) -> ((n1+n2)/2) >= 7 ? "aprovado" : "reprovado";
		
		System.out.println(resultado.apply(8.0, 8.0));
		
		Function<Double, String> conceito = m -> m >= 7 ? "aprovado" : "reprovado";
		
		//composicao de interfaces
		System.out.println(media.andThen(conceito).apply(8.0, 6.0));
		
	}

}
