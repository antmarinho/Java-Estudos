package teste.umpraum;

import dao.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;


public class ObterClienteAssento {
	
	public static void main(String[] args) {
		
		//relacao bidirecional
		
		DAO<Cliente> daoCli = new DAO<Cliente>(Cliente.class);
		
		Cliente cli = daoCli.obterPorID(2L);
		
		System.out.println(cli.getAssento().getNome());
		System.out.println(cli.getAssento().getCliente().getNome());
		
		daoCli.fechar();
		
		DAO<Assento> daoAss = new DAO<Assento>(Assento.class);
		
		Assento ass = daoAss.obterPorID(4L);
		
		System.out.println(ass.getCliente().getNome());
		
		daoAss.fechar();
		
	}

}
