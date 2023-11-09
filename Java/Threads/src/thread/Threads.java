package thread;

public class Threads {
	
	public static void main(String[] args) throws InterruptedException {
		
		new Thread() {
			
			public void run() { // o codigo q vai rodar paralelo
				
				//rotina q eu quero executar paralelo
				for(int i= 0; i < 10; i++) {
					
					//executar com tempo determinado
					
					try {
						
						System.out.println("executando rotina envio de email");
						
						Thread.sleep(500);
						
					}
					catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					
					
				}
				
			};
			
		}.start(); // liga a thread
		
		
		System.out.println("chegou ao fim");
		System.out.println("acabou");
		
	}

}
