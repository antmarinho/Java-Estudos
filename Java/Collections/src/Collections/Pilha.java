package Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		//os 2 add na pilha
		livros.add("");
		livros.push(null);
		
		//pega um elemento na pilha  o ultimo q foi adicionado
		livros.peek();
		livros.element();
		
		//remove o ultimo adicionado na pilha
		livros.poll();
		livros.pop();
		livros.remove();
		
	}
	
}
