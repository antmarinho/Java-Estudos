package Datas;

import java.time.Duration;
import java.time.Instant;

public class TempoData {
	
	public static void main(String[] args) throws InterruptedException {
		
		Instant inicio = Instant.now();
		
		Thread.sleep(2000);
		
		Instant ifinal = Instant.now();
		
		Duration duracao = Duration.between(inicio, ifinal);
		
		System.out.println("duracao nano segundos " + duracao.toNanos());
		System.out.println("duracao minutos " + duracao.toMinutes());
		System.out.println("duracao horas " + duracao.toHours());
		System.out.println("duracao milisegundos " + duracao.toMillis());
		System.out.println("duracao dias " + duracao.toDays());
		
	}

}
