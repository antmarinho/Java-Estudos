package java_jdbc.java_jdbc;


import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserJavaDAO;
import model.BeanUserFone;
import model.Telefone;
import model.UserJava;

public class Teste {
	
	@Test
	public void initBanco() {
		
		SingleConnection.getConnection();
		
		UserJavaDAO dao = new UserJavaDAO();
		UserJava user = new UserJava();
		
		user.setEmail("paulo@gmail.com");
		user.setNome("paulo");
		
		dao.salvar(user);
		
	}
	
	@Test
	public void initLista() {
		
		UserJavaDAO dao = new UserJavaDAO();
		
		List<UserJava> list = dao.listar();
		
		for (UserJava userJava : list) {
			
			System.out.println(userJava);
		}
		
	}
	
	@Test
	public void initBuscar() {
		
		UserJavaDAO dao = new UserJavaDAO();
		
		UserJava user = dao.buscar(3L);
		
		System.out.println(user);
	
	}
	
	@Test
	public void initAtualizar() {
		
		UserJavaDAO dao = new UserJavaDAO();
		
		UserJava user = dao.buscar(2L);
		
		user.setNome("ana");
		
		dao.atualizar(user);
	}
	
	@Test
	public void initDeletar() {
		
		UserJavaDAO dao = new UserJavaDAO();
		
		dao.deletar(7L);
	
	}
	
	@Test
	public void testeInsertTelefone() {
		
		UserJavaDAO dao = new UserJavaDAO();
		Telefone tel = new Telefone();
		
		tel.setNumero("(11) 9 3306-8524");
		tel.setTipo("casa");
		tel.setUser(4L);
		
		dao.salvarTelefone(tel);
	}
	
	@Test
	public void testeCarregaFonesUser() {
		
		UserJavaDAO dao = new UserJavaDAO();
				
		List<BeanUserFone> user = dao.listaUserFone(4L);	
		
		for (BeanUserFone beanUserFone : user) {
			
			System.out.println(beanUserFone);
		}
	}
	
	@Test
	public void testeDeleteUserFone() {
		
		UserJavaDAO dao = new UserJavaDAO();
		
		dao.deleteFonesUser(1L);
		
	}

}
