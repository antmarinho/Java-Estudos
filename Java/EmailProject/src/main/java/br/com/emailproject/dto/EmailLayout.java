package br.com.emailproject.dto;

import br.com.emailproject.model.Email;

public class EmailLayout {
	
	private static final String QUEBRA_LINHA_DUPLA = "<br><br>";
	private static final String QUEBRA_LINHA = "<br>";

	public Email montarEmailAdmin(String dest, String assunto) {
		
		StringBuilder texto = new StringBuilder();
		
		texto.append("A/C Administrador")
			 .append(QUEBRA_LINHA_DUPLA);
		
		texto.append("solicito alteracao de senha do sistema")
			 .append(QUEBRA_LINHA_DUPLA);
		
		gerarAssinatura(texto);
		
		gerarRodape(texto);
		
		return new Email(dest,assunto,texto.toString());
	}
	
	private String gerarAssinatura(StringBuilder texto) {
		
		texto.append("Att.:")
			 .append(QUEBRA_LINHA)
			 .append("operador de caixa")
			 .append(QUEBRA_LINHA);
		
		return texto.toString();
	}

	private String gerarRodape(StringBuilder texto) {
		
		return texto.append("E-mail automatico Por favor n responde esse e-mail").toString();
	}
	
}
