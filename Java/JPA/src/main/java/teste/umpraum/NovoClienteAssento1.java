package teste.umpraum;

import dao.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	
	public static void main(String[] args) {
		
		Assento assento = new Assento("7H");
		Cliente cliente = new Cliente("Carlos", assento);
		
		DAO<Object> dao = new DAO<Object>();

		
		dao.abrirT()
		   .incluir(assento)
		   .incluir(cliente)
		   .fecharT()
		   .fechar();
		
	}

}
