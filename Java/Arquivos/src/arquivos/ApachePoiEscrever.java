package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ApachePoiEscrever {
	
	public static void main(String[] args) throws IOException {
		
		Pessoa p1 = new Pessoa("jose", 25, "jose@gmail.com");
		Pessoa p2 = new Pessoa("maria", 18, "maria@gmail.com");
		Pessoa p3 = new Pessoa("rick", 68, "rick@gmail.com");
		
		List<Pessoa> lista = new ArrayList<>();
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		File file = new File("H:\\Java\\Arquivos\\src\\arquivos\\arquivo_excel.xls");
		
		if(!file.exists())
			file.createNewFile();
		
		HSSFWorkbook hsswb = new HSSFWorkbook(); //usado pra escrever na planilha
		
		HSSFSheet linhaPessoa = hsswb.createSheet("Planilha de pessoas"); //criar planilha
		
		int numeroLinha = 0;
		
		for(Pessoa p: lista) {
			
			Row linha = linhaPessoa.createRow(numeroLinha++); //criando a linha na planilha
			
			int celula = 0; //colunas
			
			Cell celNome = linha.createCell(celula++);
			celNome.setCellValue(p.getNome());
			
			Cell celEmail = linha.createCell(celula++);
			celEmail.setCellValue(p.getEmail());
			
			Cell celIdade = linha.createCell(celula++);
			celIdade.setCellValue(p.getIdade());
			
		} //terminou de montar a planilha
		
		FileOutputStream saida = new FileOutputStream(file);
		
		hsswb.write(saida); // escreve planilha em arquivo
		
		saida.flush();
		saida.close();
		
		System.out.println("planilha foi criada");
		
	}

}
