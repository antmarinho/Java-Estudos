package Datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CompararDatas {
	
	public static void main(String[] args) throws ParseException {
		
		
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataVencimentoBoleto = formatar.parse("10/11/2023");
		
		Date dataAtual = formatar.parse("12/11/2023");
		
		
		if (dataVencimentoBoleto.after(dataAtual)) { // se a data 1 e  maior q a data 2 after
			
			System.out.println("boletoo nao vencido");
			
		}
		else {
			
			System.out.println("boleto venceu");
			
		}
		
		
		if (dataVencimentoBoleto.before(dataAtual)) { // se a data 1 e  menor q a data 2 before
			
			System.out.println("boleto venceu");
			
		}
		else {
			
			System.out.println("boletoo nao vencido");
			
		}
		
	
	}

}
