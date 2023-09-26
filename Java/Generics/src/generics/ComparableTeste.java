package generics;

import java.util.TreeSet;

public class ComparableTeste {
	
	public static void main(String[] args) {
		
		TreeSet<Integer> num = new TreeSet<>();
		
		num.add(10);
		num.add(1);
		num.add(5);
		num.add(8);
		num.add(2);
		
		for(Integer n: num) {
			
			System.out.println(n);
		}
		
	}
	
}
