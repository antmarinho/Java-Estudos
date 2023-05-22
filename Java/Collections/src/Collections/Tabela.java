package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Tabela {

	public static void main(String[] args) {
		
		Map<Integer, String> usuario = new HashMap<Integer, String>();
		
		usuario.put(1, "roberto"); //adiciona e tbm pode substituir
		
		usuario.keySet(); //pega as chaves
		usuario.values(); //pega os valores
		usuario.entrySet(); //pegas os 2
		
		usuario.containsKey(2); //verifica se tem um chave
		usuario.containsValue(""); //verifica se tem um valor
		
		usuario.get(2); //pega elemento pela chave
		
		usuario.remove(1); //remove pela chave
		usuario.remove(1, ""); //remove pela chave e valor 
		
		//imprime as chaves 
		for(int chave: usuario.keySet()) {
			
			System.out.println(chave);
		}
		
		//imprime os valores
		for(String valor: usuario.values()) {
			
			System.out.println(valor);
		}
		
		//imprime as chaves com seus valores
		for(Entry<Integer, String> registo: usuario.entrySet()) {
			System.out.println(registo.getKey() + " " + registo.getValue());
		}
		
	}
	
}
