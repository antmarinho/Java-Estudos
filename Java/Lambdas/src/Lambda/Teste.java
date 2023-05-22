package Lambda;

public class Teste {
	
	public static void main(String[] args) {
		
		Calculo calculo = new Multiplicacao();
		
		System.out.println(calculo.executar(2, 4));
	}

}
