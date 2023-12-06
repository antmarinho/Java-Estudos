package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;
import model.ModelLogin;

public class DAOLoginRepository {
	
	private Connection con;
	
	public DAOLoginRepository() {
		
		con = SingleConnection.getConnection();
	}
	
	public boolean validarAutenticacao(ModelLogin ml) throws SQLException {
		
		String sql = "SELECT * FROM users WHERE login = ? AND senha = ?";
		
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,ml.getLogin());
			stmt.setString(2,ml.getSenha());
			
			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()) //autenticado
				return true;
			
		
		return false; //nao autenticado
	}

}
