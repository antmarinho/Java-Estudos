package generics;

public class CaixaTesteGenerics {
	
	public static void main(String[] args) {
		
		CaixaGenerics<String> caixa = new CaixaGenerics<>();
		
		caixa.guardar("ffffff");
		
		System.out.println(caixa.abrir());
		
		CaixaGenerics<Double> caixaB = new CaixaGenerics<>();
		caixaB.guardar(3.1415);
		
		System.out.println(caixaB.abrir());
		
	}

}
