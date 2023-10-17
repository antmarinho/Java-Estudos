package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT u FROM Usuario u";
		
		TypedQuery<Usuario> query = em.createQuery(jpql,Usuario.class);
		
		query.setMaxResults(5);
		
		List<Usuario> usuarios = query.getResultList();
		
		
		//busca em 1 so linha
										//faz o select
		/*List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u",Usuario.class)
								   .setMaxResults(6) //limita em 5 resultados
								   .getResultList(); //joga na lista*/
		
		
		for(Usuario usuario: usuarios) 
			System.out.println("ID: " + usuario.getId() + " E-mail: " + usuario.getEmail() + " Nome: " + usuario.getNome());
		
		emf.close();
		em.close();
		
	}

}
