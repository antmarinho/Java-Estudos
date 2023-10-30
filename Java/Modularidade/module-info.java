module app.calculo {
	
	exports com.acgm.app.calculo;
	//permitindo acesso pra modulos especificos
	exports com.acgm.app.calculo.interno to Modulariadade2, app.logging; 
	
	requires transitive app.logging;
	requires app.api;
	
	provides com.acgm.app.Calculadora 
	with com.acgm.app.calculo.CalculadoraImpl;
	
	opens com.acgm.app.calculo to Modulariadade2; //abrir especificamente 1 pacote e nao tudo
	// com o TO abre so pra um determinado
}