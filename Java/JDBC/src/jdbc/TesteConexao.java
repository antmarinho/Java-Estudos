package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {
	
	public static void main(String[] args) throws SQLException {
		
		//cria uma conexao segura mais nao verifica o certificado do servidor
		String url = "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=true";
		String usuario = "root";
		String senha = "";
		
		Connection conexao = DriverManager.getConnection(url,usuario,senha);
		
		System.out.println("conexao com sucesso");
		
		conexao.close();
		
	}
	

}
