package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
	
	public static Connection getConexao(){
		
		try{
			
			Properties prop = getProperties();
			
			String url = prop.getProperty("url");
			String usuario = prop.getProperty("user");
			String senha = prop.getProperty("pass");
			
			return DriverManager.getConnection(url,usuario,senha);
		} 
		catch (SQLException | IOException e) {
			
			throw new RuntimeException(e);
			
		}
		
	}
	
	private static Properties getProperties() throws IOException {
		
		String caminho = "/conexao.properties";
		
		Properties prop = new Properties();
	
		prop.load(FabricaConexao.class.getResourceAsStream(caminho));
		
		return prop;
	}

}
