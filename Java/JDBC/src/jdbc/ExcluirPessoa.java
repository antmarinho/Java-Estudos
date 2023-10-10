package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	
	public static void main(String[] args) throws SQLException {
		
		int codigo;
		String delete = "DELETE FROM pessoas WHERE codigo = ?";
		
		Scanner in = new Scanner(System.in);
		
		Connection conexao = FabricaConexao.getConexao();
		
		System.out.println("informe o codigo");
			codigo = in.nextInt();
		
		PreparedStatement stmt = conexao.prepareStatement(delete);
			stmt.setInt(1,codigo);
			
			if(stmt.executeUpdate() > 0)
				System.out.println("pessoa excluida");
			else
				System.out.println("pessoa n foi excluida");
		
		in.close();
		conexao.close();
		stmt.close();
		
	}

}
