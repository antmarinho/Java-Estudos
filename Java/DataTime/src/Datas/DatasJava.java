package Datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasJava {
	
	public static void main(String[] args) throws ParseException {
		
		Calendar calendario = Calendar.getInstance();
		
		Date data = new Date();
		
		System.out.println("data milisegundos " + data.getTime());
		System.out.println("calendar milisegundos " + calendario.getTimeInMillis());
		
		System.out.println("dia do mes " + data.getDate());
		System.out.println("calendar dia do mes " + calendario.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("dia da semana " + data.getDay()); // aqui domingo comeca no zero
		System.out.println("calendar dia da semana " + calendario.get(Calendar.DAY_OF_WEEK)); //aqui comeca domingo com 1
		
		System.out.println("hora do dia " + data.getHours());
		
		System.out.println("minuto do dia " + data.getMinutes());
		
		System.out.println("segundos " + data.getSeconds());
		
		System.out.println("ano " + (data.getYear() + 1900));
		
		// simple date format
		
		
		SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("data atual formatada " + formatData.format(data));
		
		formatData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("formato bando de dados " + formatData.format(data));
		
		System.out.println("retorna objeto data " + formatData.parse("1985-10-10 20:28:56"));

		
		formatData = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("retorna objeto data " + formatData.parse("1985-10-10"));
		
		formatData = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("retorna objeto data " + formatData.parse("10/10/1958"));
		
		
	}
	

}
