package teste.heranca;

import dao.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {
	
	public static void main(String[] args) {
		
		DAO<Aluno> dao = new DAO<Aluno>();
		
		Aluno aluno = new Aluno(123L, "jose");
		AlunoBolsista aluno2 = new AlunoBolsista(568L, "maria", 1000);
		
		dao.incluirAtomico(aluno);
		dao.incluirAtomico(aluno2);
		
		dao.fechar();
	}

}
