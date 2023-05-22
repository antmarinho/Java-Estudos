package Collections;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

//conjuntos
public class Conjuntos { 
	
	public static void main(String[] args) {
		
		Set<String> lista = new HashSet<String>();
		SortedSet<String> listaOrdenada = new TreeSet<String>(); //conjunto ordenado
		
		lista.add("ana");
		lista.add("joao");
		lista.add("pedro");
		
		
		lista.addAll(listaOrdenada);//uniao dos 2 conjuntos
		lista.retainAll(listaOrdenada);//intercessao 2 conjuntos
		lista.clear();//limpa conjunto
		lista.contains(" ");//verifica se o elemento contido no conjunto
		
	}

}
