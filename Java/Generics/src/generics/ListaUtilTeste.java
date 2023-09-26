package generics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTeste {
	
	public static void main(String[] args) {
		
		List<String> langs = Arrays.asList("js", "php", "java");
		List<Integer> nums = Arrays.asList(1,1,2,3,6,5);
		
		String ultimaLinguaguem = (String) ListaUtil.getUltimo1(langs);
		System.out.println(ultimaLinguaguem);
		
		Integer ultimo = (Integer) ListaUtil.getUltimo1(nums);
		System.out.println(ultimo);
		
		//nao precisa cast pq a funcao e generica
		String ultimaLinguaguem2 = ListaUtil.getUltimo2(langs);
		System.out.println(ultimaLinguaguem2);
		
		Integer ultimo2 = ListaUtil.getUltimo2(nums);
		System.out.println(ultimo2);
		
		
	}

}
