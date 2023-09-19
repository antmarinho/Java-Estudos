package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Reduce2 {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("ana", 7.5);
		Aluno a2 = new Aluno("jose", 5.5);
		Aluno a3 = new Aluno("maria", 8.5);
		Aluno a4 = new Aluno("joao", 2.5);
		Aluno a5 = new Aluno("rick", 6.5);
		
		List<Aluno> alu = Arrays.asList(a1,a2,a3,a4,a5);
		
		Predicate<Aluno> apro = a -> a.nota >= 7;
		Function<Aluno, Double> aNota = a -> a.nota;
		BinaryOperator<Double> soma = (a,b) -> a + b;
		
		alu.stream().filter(apro)
					.map(aNota)
					.reduce(soma)
					.ifPresent(System.out::println);
		
	}

}
