package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUser = new Usuario("ana","ana@gmail.com");
		
		
		//inserir
		em.getTransaction().begin();
		em.persist(novoUser);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
