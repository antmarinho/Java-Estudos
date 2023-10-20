package teste.muitospramuitos;

import dao.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {
	
	public static void main(String[] args) {
		
		Filme filA = new Filme("SW ep 4", 8.9);
		Filme filB = new Filme("o fugitivo", 8.1);
		
		Ator atA = new Ator("harrison ford");
		Ator atrB = new Ator("carrie fisher");
		
		filA.adicionarAtor(atA);
		filA.adicionarAtor(atrB);
		
		filB.adicionarAtor(atA);
		
		DAO<Filme> dao = new DAO<Filme>();
		
		dao.incluirAtomico(filA);
		
	}

}
