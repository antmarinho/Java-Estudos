package Collections;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<String>();
		
		//os 2 add na fila
		fila.add("ana"); //lanca excecao se de erro
		fila.offer("bia"); //retorna falso se de erro
		fila.add("jose");
		fila.offer("carlos");
		
		//os 2 obtem o proximo elemento da fila sem remover
		fila.peek(); //retorna falso
		fila.element(); //lanca excecao
		
		//remove elemento da fila
		fila.poll(); //retorna false
		fila.remove(); //lanca execao
		
		fila.size(); //tamanho
		fila.clear(); //limpa
		fila.isEmpty(); //testa se ta vazio
		fila.contains(""); //se contem objeto
		
		
	}
	
}
