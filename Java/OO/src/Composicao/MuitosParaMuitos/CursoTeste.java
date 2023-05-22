package Composicao.MuitosParaMuitos;

public class CursoTeste {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("pedro");
		Aluno a2 = new Aluno("jose");
		Aluno a3 = new Aluno("maria");
		
		Curso c1 = new Curso("Java");
		Curso c2 = new Curso("c++");
		Curso c3 = new Curso("web 2023");
		
		c1.adicionarAluno(a3);
		c1.adicionarAluno(a1);
		
		c2.adicionarAluno(a2);
		c2.adicionarAluno(a3);
		
		c3.adicionarAluno(a1);
		c3.adicionarAluno(a2);
		
		for(Aluno aluno: c1.alunos) {
			
			System.out.println(c1.nome);
			System.out.println(aluno.nome);
		}
		
		System.out.println(a1.cursos.get(0).alunos);
		
	}

}
