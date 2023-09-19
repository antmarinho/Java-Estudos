package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Match {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("ana", 2.5);
		Aluno a2 = new Aluno("jose", 5.5);
		Aluno a3 = new Aluno("maria", 4.5);
		Aluno a4 = new Aluno("joao", 5.5);
		Aluno a5 = new Aluno("rick", 5.5);
		
		List<Aluno> alu = Arrays.asList(a1,a2,a3,a4,a5);
		
		Predicate<Aluno> apro = a -> a.nota >= 7;
		
		System.out.println(alu.stream().allMatch(apro)); //todos foram aprovados true se sim
		System.out.println(alu.stream().anyMatch(apro)); // pelo menos 1 foi aprovado true se sim false se n tem nenhum
		System.out.println(alu.stream().noneMatch(apro)); //nenhum foi aprovador true se todos n foram
		
	}

}
