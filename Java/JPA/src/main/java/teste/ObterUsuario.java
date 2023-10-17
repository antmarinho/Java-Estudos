package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class ObterUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		//pesquisa por id
		Usuario user = em.find(Usuario.class,1L);
		
		System.out.println(user.getNome());
		
		emf.close();
		em.close();
	}

}
