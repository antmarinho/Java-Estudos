package com.acgm.app.financeiro;

import java.lang.reflect.Field;

import com.acgm.app.calculo.Calculadora;
import com.acgm.app.calculo.interno.OperacoesAritmetricas;

public class Teste {
	
	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		
		System.out.println(calc.soma(2,4,5));
		
		OperacoesAritmetricas op = new OperacoesAritmetricas();
		
		System.out.println(op.soma(1,5,2));
		
		Field fieldId = Calculadora.class.getDeclaredFields()[0];
		
		try {
			
			fieldId.setAccessible(true);
			fieldId.set(calc, "def");
			System.out.println(calc.getId());
			fieldId.setAccessible(false);
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
