package Lambda;

public class Teste2 {
	
	public static void main(String[] args) {
		
		Calculo mult = (x,y) -> { return (x * y); };
		
		System.out.println(mult.executar(2, 3));
		
		mult = (x,y) -> x*y;
		
	}

}
