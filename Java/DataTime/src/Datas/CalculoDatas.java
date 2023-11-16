package Datas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalculoDatas {
	
	public static void main(String[] args) throws ParseException {
		
		Calendar calendario = Calendar.getInstance(); // pega data atual
		
		//simular q a data vem de algum lugar
		
		calendario.setTime(new SimpleDateFormat("dd-MM-yyyy").parse("10-03-2023"));
		
		calendario.add(Calendar.DAY_OF_MONTH, 1); // adiciona dias ao mes ou se for negativo tbm diminui
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendario.getTime()));
		
		calendario.add(Calendar.MONTH, 5); //somando mes ou se for negativo tbm diminui
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendario.getTime()));
		
		calendario.add(Calendar.YEAR, 2); //somar ano ou diminuir ano se for negativo
		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(calendario.getTime()));
	}

}
