package Function;

import java.util.function.Function;

public class Funcao {
	
	public static void main(String[] args) {
		
		Function<Integer,String> parImpar = 
				num -> (num % 2) == 0 ? "Par" : "Impar";
				
				
		System.out.println(parImpar.apply(5));
		
		
		Function<String,String> resultado = 
				valor -> "o resultado e " + valor;
				
		String resultadoFinal = parImpar.andThen(resultado).apply(35);
		
		System.out.println(resultadoFinal);
		
	}

}
