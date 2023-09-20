package Exception.personalizadaException;

@SuppressWarnings("serial")
public class StringVazioException extends Exception{
	
	private String nomeAtributo;
	
	public StringVazioException(String nomeAtributo) {
		
		this.nomeAtributo = nomeAtributo;
		
	}
	
	public String getMessage() {
		
		return String.format("o atributo %s esta vazio", nomeAtributo);
		
	}

}

