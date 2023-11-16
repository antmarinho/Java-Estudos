package Datas;

import java.time.LocalDate;
import java.time.Period;

public class PeriodoData {
	
	public static void main(String[] args) {
		
		//LocalDate dataAntiga = LocalDate.of(2020, 3, 5);
		LocalDate dataAntiga = LocalDate.parse("2020-03-05"); //2 modos
		
		LocalDate dataNova = LocalDate.of(2023, 11, 16);
		
		System.out.println("data antiga e maior q data nova " + dataAntiga.isAfter(dataNova));
		System.out.println("data antiga e anterior a data nova " + dataAntiga.isBefore(dataNova));
		System.out.println("data antiga e igual a data nova " + dataAntiga.isEqual(dataNova));
		
		Period periodo = Period.between(dataAntiga, dataNova);
		
		System.out.println("quantos dia " + periodo.getDays());
		System.out.println("quantos meses " + periodo.getMonths());
		System.out.println("quantos anos " + periodo.getYears());
		System.err.println("total de meses " + periodo.toTotalMonths());
		
		System.out.println("periodo e " + periodo.getYears() + " anos " + periodo.getMonths() + " meses " + periodo.getDays() + " dias");
		
	}

}
