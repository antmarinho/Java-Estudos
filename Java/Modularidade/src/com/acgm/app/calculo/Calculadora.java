package com.acgm.app.calculo;

import com.acgm.app.calculo.interno.*;
import com.acgm.app.logging.Logger;

public class Calculadora {
	
	private String id = "abc";
	
	private OperacoesAritmetricas op = new OperacoesAritmetricas();

	public double soma(double... nums) {
		
		Logger.info("somando...");
		
		return op.soma(nums);
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
