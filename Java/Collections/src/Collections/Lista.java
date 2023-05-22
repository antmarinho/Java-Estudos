package Collections;

import java.util.ArrayList;
import java.util.List;

public class Lista {
	
	public static void main(String[] args) {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		Usuario u1 = new Usuario("ana");
		
		lista.add(u1);
		lista.add(new Usuario("jose"));
		lista.add(new Usuario("maria"));
		lista.add(new Usuario("pedro"));
		
		System.out.println(lista.get(2)); //pesquisa pelo indice
		
		lista.remove(0); //remove pelo indice
		lista.remove(u1); //remove pelo objeto
		lista.contains(u1); //mostra se contem o objeto
		
		
	}

}
