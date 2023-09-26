package generics;

public class CaixaTeste {
	
	public static void main(String[] args) {
		
		Caixa a = new Caixa();
		
		a.guardar(2.3);
		
		//erro pq cast e de inteiro no double
		Integer coisa = (Integer) a.abrir();
		
		System.out.println(coisa);
		
	}

}
