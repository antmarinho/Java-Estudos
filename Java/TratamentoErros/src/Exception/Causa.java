package Exception;

public class Causa {
	
	//excecoes encadeada uma gerando a outra
	
	public static void main(String[] args) {
		
		
		try {
			
			metodoA(null);
			
		} catch (IllegalArgumentException e) {
			
			if(e.getCause() != null) {
				
				System.out.println(e.getCause().getMessage());
			}
			
		}
		
		metodoA(null);
		
	}
	
	static void metodoA(Aluno aluno)
	{
		try {
			
			metodoB(aluno);
			
		} catch (Exception e) {
			
			throw new IllegalArgumentException(e);
			
		}
		
	}
	
	static void metodoB(Aluno aluno)
	{
		if(aluno == null) {
			
			throw new NullPointerException("aluno esta nulo");
		}
		
		System.out.println(aluno.nome);
		
	}

}
