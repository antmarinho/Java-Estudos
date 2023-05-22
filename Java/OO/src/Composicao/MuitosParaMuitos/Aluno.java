package Composicao.MuitosParaMuitos;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	final String nome;
	final List<Curso> cursos = new ArrayList<Curso>();
	
	
	public Aluno(String nome) {
		
		this.nome = nome;
		
	}

	void adicionarCurso(Curso curso) {
		
		this.cursos.add(curso);
		curso.alunos.add(this);
		
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", cursos=" + cursos + "]";
	}
	
}
