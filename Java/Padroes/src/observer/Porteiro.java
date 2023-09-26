package observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Porteiro {
	
	private List<Observer> ob = new ArrayList<>();
	
	public void registraObservador(Observer o) {
		
		ob.add(o);
		
	}
	
	public void monitorar() {
		
		Scanner in = new Scanner(System.in);
		
		String valor = "";
		
		while(!"sair".equalsIgnoreCase(valor)) {
			
			System.out.println("Aniversariante chegou? ");
				valor = in.nextLine();
				
			if("sim".equalsIgnoreCase(valor)) {
				
				EventoChegadaAniversariante evento = new EventoChegadaAniversariante(new Date());
				
				ob.stream().forEach(o -> o.chegou(evento));
				
				valor = "sair";
				
			}
			else if("nao".equalsIgnoreCase(valor)){
				
				System.out.println("alarme falso");
				
			}
			
			in.close();
			
		}
		
	}

}
