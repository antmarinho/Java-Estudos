package Datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GerarDatasBoletoExemplo {
	
	public static void main(String[] args) throws ParseException {
		
		Date dataInicial = new SimpleDateFormat("dd/MM/yyyy").parse("16/11/2023"); //data inicial
		
		Calendar calendario = Calendar.getInstance();
		
		calendario.setTime(dataInicial);
		
		for(int i = 1; i <= 12; i++) {
			
			calendario.add(Calendar.MONTH, 1); //adicionando 1 mes pra gerar 12 parcelas
			
			System.out.println("Parcela de numero: " + i + " vencimento e em: " + new SimpleDateFormat("dd/MM/yyyy").format(calendario.getTime()));
			
			
		}
		
	}

}
