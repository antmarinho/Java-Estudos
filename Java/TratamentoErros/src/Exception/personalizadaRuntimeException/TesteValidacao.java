package Exception.personalizadaRuntimeException;

import Exception.Aluno;

public class TesteValidacao {
	
	public static void main(String[] args) {
		
		try {
		
			Aluno aluno = new Aluno("j",5);
			Validar.aluno(aluno);
			
			Validar.aluno(null);
			
		} catch (StringVazioException e) {
			
			System.out.println(e.getMessage());
			
		} catch (NumeroForaIntervaloException | IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
		}
			
	}

}
