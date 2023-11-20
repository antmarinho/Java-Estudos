package arquivos;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;

public class ApachePoiLeitura {
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream entrada = new FileInputStream(new File("H:\\Java\\Arquivos\\src\\arquivos\\arquivo_excel.xls"));
		
		HSSFWorkbook hsswb = new HSSFWorkbook(entrada); // prepara a entrada do arquivo excel para ler
		
		HSSFSheet planilha = hsswb.getSheetAt(0); //pega a primeira planilha excel
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(linhaIterator.hasNext()) { //enquanto tiver linha no arquivo do excel
			
			Row linha = linhaIterator.next(); //pegando dados da pessoa na linha
			
			Iterator<Cell> celula = linha.iterator(); //percorrer as colunas
			
			Pessoa pessoa = new Pessoa();
			
			while(celula.hasNext()) { 
				
				Cell cel = celula.next();
				
				switch (cel.getColumnIndex()) {
				
					case 0:
					
						pessoa.setNome(cel.getStringCellValue());
					
					break;
					
					case 1:
					
						pessoa.setEmail(cel.getStringCellValue());
					
					break;
				
					case 2:
					
						pessoa.setIdade(Double.valueOf(cel.getNumericCellValue()).intValue());
					
					break;
				
				}
				
			} // fim das celulas da linha
			
			pessoas.add(pessoa);
			
		}
		
		entrada.close();
		
		for(Pessoa p: pessoas)
			System.out.println(p);
		
	}

}
