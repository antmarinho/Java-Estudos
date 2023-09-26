package observer;

public class Namorada implements Observer{

	@Override
	public void chegou(EventoChegadaAniversariante evento) {
		
		System.out.println("avisar convidados");
		System.out.println("apagar luzes");
		System.out.println("surpresa");
		
	}

}
