package com.acgm.app.financeiro;

import java.util.ServiceLoader;
import com.acgm.app.Calculadora;


public class Teste {
	
	public static void main(String[] args) {
		
		//CalculadoraImpl calc = new CalculadoraImpl();
		
		Calculadora calc = ServiceLoader.load(Calculadora.class)
										.findFirst()
										.get();
		
		System.out.println(calc.soma(2,4,5));
		
		//OperacoesAritmetricas op = new OperacoesAritmetricas();
		
		//System.out.println(op.soma(1,5,2));
		
		//Field fieldId = CalculadoraImpl.class.getDeclaredFields()[0];
		
		/*try {
			
			fieldId.setAccessible(true);
			fieldId.set(calc, "def");
			System.out.println(calc.getId());
			fieldId.setAccessible(false);
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}*/
		
		
	}

}
