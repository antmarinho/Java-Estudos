package Exception.personalizadaException;

import Exception.Aluno;

public class Validar {
	
	private Validar() {}
	
	public static void aluno(Aluno aluno) throws StringVazioException, NumeroForaIntervaloException {
		
		if(aluno == null) {
			
			throw new IllegalArgumentException("o aluno esta nulo");
		}
		
		if(aluno.nome == null || aluno.nome.trim().isEmpty()){
			
			throw new StringVazioException("nome");
		}
		
		if(aluno.nota < 0 || aluno.nota > 10) {
			
			throw new NumeroForaIntervaloException("nota");
		}
		
		
	}

}


