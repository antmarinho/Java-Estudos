package br.com.acgm.email;


public class Test {
	
	@org.junit.Test
	public void testeEmail() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("ola, <br/><br/>");
		sb.append("<h2>vc estar recebendo acesso ao curso java <br/><br/></h2>");
		sb.append("para ter acesso clique no link abaixo <br/> <br/>");
		
		sb.append("<b>Login:</b> jose@gmail.com <br/>");
		sb.append("<b>senha:</b> fgfdhfdhfjgs <br/><br/>");
		
		sb.append("<a target=\"_blank\" href=\"https://google.com.br\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block; border-radius: 30px; font-size:20px; font-family:courier; border: 3px solid green;background-color:#99DA39;\">Acessar portal</a><br/><br/>");
		
		sb.append("<span style=\"font-size: 8px\">Ass.: Alex do JDev</span>");
		
		ObjetoEnviarEmail enviarEmail = new ObjetoEnviarEmail("ant.marinho145@gmail.com","Antonio Marinho","testando email",sb.toString());
		
		enviarEmail.enviarEmail(true);
	
	}

}
