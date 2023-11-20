package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEditandoNovaColuna {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("H:\\Java\\Arquivos\\src\\arquivos\\arquivo_excel.xls");
		
		FileInputStream entrada = new FileInputStream(file);
		
		HSSFWorkbook hsswb = new HSSFWorkbook(entrada); //prepara a entrada do arquivo xls excel
		
		HSSFSheet planilha = hsswb.getSheetAt(0); // pegando a planilha
		
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while(linhaIterator.hasNext()) { //enquanto tivet linha
			
			Row linha = linhaIterator.next(); //dados da pessoa na linha
			
			int numColunas = linha.getPhysicalNumberOfCells(); //quantidade de coluna
			
			Cell cel = linha.createCell(numColunas); //cria nova coluna
			cel.setCellValue("5.458,5");
			
		}
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		
		hsswb.write(saida);
		
		saida.flush();
		saida.close();
		
		System.out.println("planilha atualizada");
		
	}

}
