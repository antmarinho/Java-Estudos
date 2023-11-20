package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreverArquivo {
	
	public static void main(String[] args) throws IOException {
		
		Pessoa p1 = new Pessoa("jose", 25, "jose@gmail.com");
		Pessoa p2 = new Pessoa("maria", 18, "maria@gmail.com");
		Pessoa p3 = new Pessoa("rick", 68, "rick@gmail.com");
		
		//pode vim de um banco de dados ou quanquer fonte
		List<Pessoa> lista = new ArrayList<>();
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		//File arquivo = new File("H:\\Java\\Arquivos\\src\\arquivos\\arquivo.txt");
		
		//tabela excel o ; ele trata cada um por coluna
		File arquivo = new File("H:\\Java\\Arquivos\\src\\arquivos\\arquivo.csv");
		
		
		if(!arquivo.exists())
			arquivo.createNewFile();
		
		FileWriter escreverArquivo = new FileWriter(arquivo); // objeto pra escrever arquivo
		
		/*for(int i = 0; i <= 10; i++) {
			
			escreverArquivo.write("texto da minha linha " + (i + 1) + "\n");
			
		}*/
		
		for(Pessoa p : lista)
			escreverArquivo.write(p.getNome() + ";" + p.getIdade() + ";" + p.getEmail() + "\n");
		
		escreverArquivo.flush();
		escreverArquivo.close();
		
		
	}

}
