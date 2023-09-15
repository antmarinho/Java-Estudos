package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {

	public static void main(String[] args) {
		
		//interface pra imprimir
		Consumer<String> print = System.out::print;
		Consumer<Integer> println = System.out::println;
		
		//criando stream modo estatico
		Stream<String> lang = Stream.of("java ","lua ","js\n"); 
		lang.forEach(print);
		
		String[] maisLang = {"python ", "lisp ", "Perl ", "go\n"};
		
		//criando passando um array
		Stream.of(maisLang).forEach(print);
		
		//usando arrays e passando uma array pra criar uma stream
		Arrays.stream(maisLang).forEach(print);
		Arrays.stream(maisLang, 0, 2).forEach(print);
		
		//usando colecoes
		List<String> outrasLang = Arrays.asList("\nc ", "php ", "c++\n");
		outrasLang.stream().forEach(print);
		outrasLang.parallelStream().forEach(print); //thread executando paralelo
		
		//Stream.generate(() -> "a").forEach(print); //stream infinita sem ordem
		//Stream.iterate(0, n -> n + 1).forEach(println); //stream infinita com ordem
		
	}
	
}
