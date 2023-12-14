package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;
import model.Users;

public class DAOUsuarioRepository {
	
	private Connection con;
	

	public DAOUsuarioRepository() {
		con = SingleConnection.getConnection();
	}
	
	public Users gravarUsuario(Users ml) throws SQLException {
		
		if(ml.isNovo()) { //grava um novo
		
			String sql = "INSERT INTO users (login,senha,nome,email) VALUES (?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, ml.getLogin());
			stmt.setString(2, ml.getSenha());
			stmt.setString(3, ml.getNome());
			stmt.setString(4, ml.getEmail());
			
			stmt.execute();
			
			con.commit();
			
		} else {
			
			String sql = "UPDATE users SET senha = ?, nome = ?, email = ? WHERE id = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,ml.getSenha());
			stmt.setString(2,ml.getNome());
			stmt.setString(3,ml.getEmail());
			stmt.setLong(4,ml.getId());
			
			stmt.executeUpdate();
			
			con.commit();
		}
		
		return this.consultaUsuario(ml.getLogin());
	}
	
	public Users consultaUsuario(String login) throws SQLException {
		
		Users ml = new Users();
		
		String sql = "SELECT * FROM users WHERE upper(login) = upper(?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1,login);
		
		ResultSet rs = stmt.executeQuery();
		
		//se tem resultado
		while(rs.next()) { 
			
			ml.setId(rs.getLong("id"));
			ml.setNome(rs.getString("nome"));
			ml.setLogin(rs.getString("login"));
			ml.setEmail(rs.getString("email"));
			ml.setSenha(rs.getString("senha"));
			
		}
			
		return ml;
	}
	
	public boolean validarLogin(String login) throws SQLException {
		
		String sql = "SELECT count(1) > 0 as existe from users where upper(login) = upper(?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, login);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next())
			return rs.getBoolean("existe");
			
		return false;
	}
	
	public void deletarUser(String id) throws SQLException {
		
		String sql = "DELETE FROM users WHERE id = ?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setLong(1,Long.parseLong(id));
		
		stmt.executeUpdate();
		
		con.commit();
		
	}
	
}
