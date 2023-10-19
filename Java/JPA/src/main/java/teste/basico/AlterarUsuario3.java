package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario user = em.find(Usuario.class, 6L);
		
		em.detach(user); //so vai fazer update se chamar o codigo
		
		user.setNome("Ana Maria");
		user.setEmail("anamaria@gmail.com");
		
		em.merge(user);
		
		em.getTransaction().commit();
		
		emf.close();
		em.close();
		
	}

}

