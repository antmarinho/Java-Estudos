package Desafio;

import java.text.DecimalFormat;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import Predicate.Produto;

public class Desafio {
	
	public static void main(String[] args) {
		
		//minha resolucao
		
		Produto p = new Produto("livro", 3235.89, 0.13);
		
		BinaryOperator<Double> preco = (valor,desc) -> (valor - (valor*desc));
		
		Function<Double, Double> impMuni = valor -> valor >= 2500 ? (valor*1.085) : (valor);
		Function<Double, Double> frete = valor -> valor >= 3000 ? (valor+100) : (valor+50);
		Function<Double, String> truncar = valor -> {
			
			String result = new DecimalFormat("##0.00").format(valor);
			
			return result;
		};
		
		Function<String, String> formatar = format -> {
			
			String result = "R$" + format;
			
			return result;
		};
		
		System.out.println(preco.andThen(impMuni)
								.andThen(frete)
								.andThen(truncar)
								.andThen(formatar)
								.apply(p.preco, p.desconto));
		
		//resolucao mellhor 
		
		
		Function<Produto, Double> precDesc = prod -> (prod.preco * (1-prod.desconto));
		
		UnaryOperator<Double> impMun = prec -> prec >= 2500 ? (prec*1.085) : prec;
		UnaryOperator<Double> fret = valor -> valor >= 3000 ? (valor+100) : (valor+50);
		UnaryOperator<Double> trunc = valor -> Double.parseDouble(String.format("%.2f", valor));
		
		Function<Double, String> forma = valor -> ("R$" + valor).replace(".", ",");
		
		
		String pFinal = precDesc.andThen(impMun)
							 .andThen(fret)
							 .andThen(trunc)
							 .andThen(forma)
							 .apply(p);
		
		System.out.println(pFinal);
		
	}

}
