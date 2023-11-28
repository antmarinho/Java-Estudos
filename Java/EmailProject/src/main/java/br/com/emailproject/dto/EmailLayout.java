package br.com.emailproject.dto;

import br.com.emailproject.model.Email;

public class EmailLayout {

	public Email montarEmailAdmin(String dest, String assunto) {
		
		StringBuilder texto = new StringBuilder();
		
		return new Email(dest,assunto,texto.toString());
	}
	
}
