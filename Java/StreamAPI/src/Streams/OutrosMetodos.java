package Streams;

import java.util.Arrays;
import java.util.List;

public class OutrosMetodos {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("ana", 7.5);
		Aluno a2 = new Aluno("jose", 7.5);
		Aluno a3 = new Aluno("maria", 8.5);
		Aluno a4 = new Aluno("joao", 9.5);
		Aluno a5 = new Aluno("rick", 6.5);
		Aluno a6 = new Aluno("joao", 2.5);
		Aluno a7 = new Aluno("ana", 7.5);
		
		List<Aluno> aluno = Arrays.asList(a1,a2,a3,a4,a5,a6,a7);
		
		System.out.println("distinct");
		
		aluno.stream().distinct().forEach(System.out::println);
		
		System.out.println("skip/limit");
		
		aluno.stream().distinct().skip(1).limit(3).forEach(System.out::println);
		
		//skip pula elementos //limita numero de elementos
		
		System.out.println("takewhile");
		
		//enquanto n encontrar o falso ele continua
		aluno.stream().distinct().takeWhile(a -> a.nota >= 7).forEach(System.out::println);
		
	}

}
