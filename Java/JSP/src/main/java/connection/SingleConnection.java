package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/teste";
	private static String pass = "123456";
	private static String user = "acgm";
	private static Connection con = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(con == null) {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(url, user, pass);
				con.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;	
	}

}
