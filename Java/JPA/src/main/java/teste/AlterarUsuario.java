package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class AlterarUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario user = em.find(Usuario.class, 6L);
		
		user.setNome("Ana Maria");
		user.setEmail("anamaria@gmail.com");
		
		em.merge(user); //pra alterar update
		
		em.getTransaction().commit();
		
		emf.close();
		em.close();
		
	}

}
