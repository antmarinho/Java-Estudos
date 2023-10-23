package teste.consulta;

import dao.DAO;
import modelo.consulta.NotaFilme;

public class ObterMediaFilmes {
	
	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<NotaFilme>(NotaFilme.class);
		
		NotaFilme nota = dao.consultarUM("obterMediaGeral");
		
		System.err.println(nota.getMedia());
		
		dao.fechar();
		
	}

}
