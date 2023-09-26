package observer;

public class Festa {
	
	public static void main(String[] args) {
		
		Namorada n = new Namorada();
		Porteiro p = new Porteiro();
		
		p.registraObservador(n);
		
		//usando lambda
		p.registraObservador(e -> {
			System.out.println("supresa via lambda");
		});
		
		p.monitorar();
		
	}

}
