package Datas;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class CalculoDatas2 {
	
	public static void main(String[] args) throws ParseException {
		
		//Date dataPassada = new SimpleDateFormat("dd-MM-yyyy").parse("01/02/2021");
		
		long dias;
		
		//total de dias de uma data ate hoje
		dias = ChronoUnit.DAYS.between(LocalDate.parse("2022-11-16"),LocalDate.now());
		
		
		System.out.println("passou " + dias + " dias da data escolhida");
		
		
	}

}
