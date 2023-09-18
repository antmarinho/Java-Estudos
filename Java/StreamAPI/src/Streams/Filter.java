package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("ana" , 7.8);
		Aluno a2 = new Aluno("jose" , 5.8);
		Aluno a3 = new Aluno("joao" , 8.8);
		Aluno a4 = new Aluno("rick" , 1.8);
		Aluno a5 = new Aluno("maria" , 9.8);
		
		List<Aluno> alunos = Arrays.asList(a1,a2,a3,a4,a5);
		
		Predicate<Aluno> aprovado = a -> a.nota >= 7;
		Function<Aluno, String> saudacao = a -> "parabens " + a.nome + " voce foi aprovado";
		 
		alunos.stream().filter(aprovado)
					   .map(saudacao)
					   .forEach(System.out::println);
		
	}

}
