package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
	
	public static void main(String[] args) throws SQLException {
		
		String nome;

		Scanner in = new Scanner(System.in);
		
		System.out.println("informe o nome");
			nome = in.nextLine();
			
		Connection conexao = FabricaConexao.getConexao();
		
		String sql = "INSERT INTO pessoas(nome) VALUES (?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();
		
		System.out.println("pessoa add");
		
		in.close();
		conexao.close();
		
	}

}
