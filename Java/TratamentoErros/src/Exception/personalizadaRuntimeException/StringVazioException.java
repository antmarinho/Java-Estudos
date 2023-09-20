package Exception.personalizadaRuntimeException;

@SuppressWarnings("serial")
public class StringVazioException extends RuntimeException{
	
	private String nomeAtributo;
	
	public StringVazioException(String nomeAtributo) {
		
		this.nomeAtributo = nomeAtributo;
		
	}
	
	public String getMessage() {
		
		return String.format("o atributo %s esta vazio", nomeAtributo);
		
	}

}

