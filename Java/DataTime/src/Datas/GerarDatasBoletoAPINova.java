package Datas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GerarDatasBoletoAPINova {
	
	public static void main(String[] args) {
		
		LocalDate dataBase = LocalDate.parse("2023-11-16");
		
		System.out.println("mais 5 dias " + (dataBase = dataBase.plusDays(5)));
		System.out.println("mais 2 semanas " + (dataBase = dataBase.plusWeeks(2)));
		System.out.println("mais 5 anos " + (dataBase = dataBase.plusYears(5)));
		System.out.println("mais 2 meses " + (dataBase = dataBase.plusMonths(2)));
		
		System.out.println("menos 1 ano " + (dataBase = dataBase.minusYears(1)));
		System.out.println("menos 1 mes " + (dataBase = dataBase.minusMonths(1)));
		System.out.println("menos 1 dias " + (dataBase = dataBase.minusDays(1)));
		System.out.println("menos 1 semana " + (dataBase = dataBase.minusWeeks(1)));
		
		for(int mes = 1; mes <= 12; mes++) {
			
			dataBase = dataBase.plusMonths(1);
			
			System.out.println("data vencimento boleto " + dataBase.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			
		}
		
	}

}
