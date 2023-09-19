package Streams;

public class Media {
	
	private double total;
	private int quantidade;
	
	public Media adicionar(double valor) {
		
		total += valor;
		quantidade++;
		
		return this;
		
	}
	
	public static Media combinar(Media m1, Media m2) {
		
		Media res = new Media();
		
		res.quantidade = m1.quantidade + m2.quantidade;
		res.total = m1.total + m2.total;
		
		return res;
		
	}
	
	public double getValor() {
		
		return total/quantidade;
		
	}

}
