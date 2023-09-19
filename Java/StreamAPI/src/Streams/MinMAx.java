package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMAx {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("ana", 7.5);
		Aluno a2 = new Aluno("jose", 5.5);
		Aluno a3 = new Aluno("maria", 8.5);
		Aluno a4 = new Aluno("joao", 2.5);
		Aluno a5 = new Aluno("rick", 6.5);
		
		List<Aluno> alu = Arrays.asList(a1,a2,a3,a4,a5);
		
		Comparator<Aluno> melhorNota = (al1, al2) -> {
			
			if(al1.nota > al2.nota) return 1;
			if(al1.nota < al2.nota) return -1;
			return 0;
			
		};
		
		System.out.println(alu.stream().max(melhorNota).get());
		System.out.println(alu.stream().min(melhorNota).get());
		
	}

}
