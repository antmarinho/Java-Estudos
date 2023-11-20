package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//ler arquivo
		
		//FileInputStream entradaArquivo = new FileInputStream(new File("H:\\Java\\Arquivos\\src\\arquivos\\arquivo.txt"));
		
		//ler aquivo de uma planilha do excel
		FileInputStream entradaArquivo = new FileInputStream(new File("H:\\Java\\Arquivos\\src\\arquivos\\arquivo.csv"));
		
		Scanner lerArquivo = new Scanner(entradaArquivo,"UTF-8");
		
		List<Pessoa> pessoa = new ArrayList<>();
		
		while(lerArquivo.hasNext()) {
			
			String linha = lerArquivo.nextLine();
			
			if(linha != null && !linha.isEmpty()) {
				
				String dados[] = linha.split("\\;");
				
				Pessoa p = new Pessoa();
				
				p.setNome(dados[0]);
				p.setIdade(Integer.parseInt(dados[1]));
				p.setEmail(dados[2]);
				
				pessoa.add(p);
				
			}
			
		}
		
		for(Pessoa p:pessoa) //poderia grava no banco de dados ou outras coisas
			System.out.println(p);
		
	}

}
