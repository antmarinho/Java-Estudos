package thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {
	
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilhaFila = new ConcurrentLinkedQueue<>();
	
	public static void add(ObjetoFilaThread ob) {
		
		pilhaFila.add(ob);
		
	}
	
	@Override
	public void run() {
		
		
		while(true) {
		
			synchronized (pilhaFila) { //bloquear o acesso a esta lista por outro processo
		
				Iterator it = pilhaFila.iterator();
				
				while(it.hasNext()) { //enquanto tiver dados na lista
			
					ObjetoFilaThread processar = (ObjetoFilaThread) it.next(); //pega objeto atual
			
					//processa 10m nota fiscal
					//gera lista enorme de pdf
					//gera envio de emails
				
					System.out.println(processar.getEmail());
					System.out.println(processar.getNome());
			
					it.remove();
			
					try { // da um tempo pra descarga de memoria
				
						Thread.sleep(1000);
				
					} 
					catch (InterruptedException e) {
				
						e.printStackTrace();
					}
			
				}
			
			}
			
			try { // outro tempo
				
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
			
				e.printStackTrace();
			} 
			
		}
		
		
	}
	

}
