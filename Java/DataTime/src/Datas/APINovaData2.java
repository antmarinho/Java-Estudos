package Datas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class APINovaData2 {
	
	public static void main(String[] args) {
		
		LocalDate localdata = LocalDate.now();
		
		System.out.println(localdata.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		System.out.println("dia da semana " + localdata.getDayOfWeek());
		
		System.out.println("dia da mes " + localdata.getDayOfMonth());
		
		System.out.println("dia do ano " + localdata.getDayOfYear());
		
		System.out.println("mes " + localdata.getMonthValue());
		System.out.println("mes " + localdata.getMonth());
		
		System.out.println("ano " + localdata.getYear());
		
		
	}

}
