package thread;

public class Threads {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread threadEmail = new Thread(thread1); //thread 1 envio de email
			
		threadEmail.start();
		
		//---------------------------------------------------------------------------------------------------------------
		
		Thread threadNota = new Thread(thread2); // thread 2 envio de nota fiscal
		
		threadNota.start();
		
		System.out.println("chegou ao fim");
		System.out.println("acabou");
		
	}
	
	public static Runnable thread1 = new Runnable() {
		
		public void run() {
			
			// o codigo q vai rodar paralelo
			
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
			
		}
		
	};
	
	public static Runnable thread2 = new Runnable() {
		
		public void run() {
			
			// o codigo q vai rodar paralelo
			
			//rotina q eu quero executar paralelo
			for(int i= 0; i < 10; i++) {
				
				//executar com tempo determinado
				
				try {
					
					System.out.println("executando rotina envio de nota fiscal");
					
					Thread.sleep(1000);
					
				}
				catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				
			}
			
		}
		
	};

}
