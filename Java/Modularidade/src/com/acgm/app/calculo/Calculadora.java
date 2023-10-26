package com.acgm.app.calculo;

import com.acgm.app.calculo.interno.*;

public class Calculadora {
	
	private OperacoesAritmetricas op = new OperacoesAritmetricas();

	public double soma(double... nums) {
		
		return op.soma(nums);
		
	}

}
