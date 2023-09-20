package Exception.personalizadaException;

@SuppressWarnings("serial")
public class NumeroForaIntervaloException extends Exception {
	
	private String nomeAtributo;
	
	public NumeroForaIntervaloException(String nomeAtributo) {
		
		this.nomeAtributo = nomeAtributo;
		
	}
	
	public String getMessage() {
		
		return String.format("o atributo %s esta fora do intervalo", nomeAtributo);
		
	}

}
