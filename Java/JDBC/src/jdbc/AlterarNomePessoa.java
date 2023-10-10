package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {
	
	public static void main(String[] args) throws SQLException {
		
		int codigo;
		String novo;
		String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		String select = "SELECT * FROM pessoas WHERE codigo = ?";
		
		Scanner in = new Scanner(System.in);
		Scanner inStr = new Scanner(System.in);
		
		Connection conexao = FabricaConexao.getConexao();
		
		System.out.println("Informe o codigo da pessoa");
			codigo = in.nextInt();
			
		PreparedStatement stmt = conexao.prepareStatement(select);
			stmt.setInt(1, codigo);
			
		ResultSet r = stmt.executeQuery();
		
		if(r.next()) {
			
			Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
			
			System.out.println("nome atual e " + p.getNome());
			
			System.out.println("informe novo nome");
				novo = inStr.nextLine();
			
			stmt.close();
			
			stmt = conexao.prepareStatement(update);
			stmt.setString(1,novo);
			stmt.setInt(2, codigo);
			stmt.execute();
			
			System.out.println("pessoa atualizada");
			
			
		}
		
		conexao.close();
		in.close();
		inStr.close();
		stmt.close();
		
	}
	
}
