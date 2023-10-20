package teste.consulta;

import java.util.List;
import dao.DAO;
import modelo.muitospramuitos.Filme;
import modelo.muitospramuitos.Ator;

public class ObterFIlmes {
	
	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<Filme>(Filme.class);
		
		List<Filme> filmes = dao.consultar("obterFilmesNotaMaiorQue", "nota", 8.5);
		
		for(Filme filme: filmes) {
			
			System.out.println(filme.getNome() + " => " + filme.getNota());
	
			for(Ator ator: filme.getAtores())
			System.out.println(ator.getNome());
		
		}
		
	}

}
