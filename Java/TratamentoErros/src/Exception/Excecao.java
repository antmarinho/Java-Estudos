package Exception;

public class Excecao {
	
	public static void main(String[] args) {
		
		Aluno a1 = null;
		
		try {
			
			imprimir(a1);
			
		}
		catch(Exception excecao) {
			
			System.out.println("erro ao imprimir");
			
		}
		
		try {
			
			System.out.println(7/0);
			
		} catch (Exception e) {
			
			System.out.println("erro foi " + e.getMessage());
		}
		
	}
	
	public static void imprimir(Aluno aluno) {
		
		System.out.println(aluno.nome);
		
	}

}
