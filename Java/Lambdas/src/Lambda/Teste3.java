package Lambda;

import java.util.function.BinaryOperator;

public class Teste3 {
	
	public static void main(String[] args) {
		
		//interfaces funcionais
		
		BinaryOperator<Double> calc = (x,y) -> x + y; // operacao com msm tipo
		
		System.out.println(calc.apply(2.2,5.5));
	}

}
