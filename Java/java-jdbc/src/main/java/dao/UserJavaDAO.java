package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.UserJava;

public class UserJavaDAO {
	
	private Connection con;
	
	public UserJavaDAO() {
		con = SingleConnection.getConnection();
	}
	
	public void salvar(UserJava user) {
		
		String sql = "INSERT INTO userjava (nome,email) values (?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.execute();
			
			con.commit();
			
			
		} catch (Exception e) {
			
			try {
				con.rollback();
				
			}catch (SQLException el) {
			
				el.printStackTrace();
			}
		
		}
			
	}
	
	public List<UserJava> listar(){
		
		List<UserJava> list = new ArrayList<>();
		
		String sql = "SELECT * FROM userjava";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet resul = stmt.executeQuery();
			
			while (resul.next()) {
				
				UserJava user = new UserJava();
				
				user.setId(resul.getLong("id"));
				user.setNome(resul.getNString("nome"));
				user.setEmail(resul.getNString("email"));
				
				list.add(user);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return list;
	}
	
	public UserJava buscar(Long id){
		
		UserJava user = new UserJava();
		
		String sql = "SELECT * FROM userjava WHERE id = " + id;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet resul = stmt.executeQuery();
			
			while (resul.next()) {
				
				user.setId(resul.getLong("id"));
				user.setNome(resul.getNString("nome"));
				user.setEmail(resul.getNString("email"));
				
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return user;
	}
	
	public void atualizar(UserJava user) {
		
		String sql = "UPDATE userjava SET nome = ? WHERE id = " + user.getId();
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.execute();
			
			con.commit();
			
		} catch (Exception e) {
			
			try {
				
				con.rollback();
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			
			e.printStackTrace();
		}
	
	}
	
	public void deletar(Long id) {
		
		try {
			
			String sql = "DELETE FROM userjava WHERE id = " + id;
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.execute();
			
			con.commit();
			
		} catch (Exception e) {
			
			try {
				
				con.rollback();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
	}
	
	public void salvarTelefone(Telefone tel) {
		
		try {
			
			String sql = "INSERT INTO telefone_user(numero, tipo, id_user) VALUES(?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,tel.getNumero());
			stmt.setString(2, tel.getTipo());
			stmt.setLong(3, tel.getUser());
			stmt.execute();
			
			con.commit();
			
		} catch (Exception e) {
			
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		
	}
	
	public List<BeanUserFone> listaUserFone(Long id){
		
		List<BeanUserFone> lista = new ArrayList<>();
		
		String sql = "SELECT nome,numero,email FROM telefone_user T "
				+ "INNER JOIN userjava U ON T.id_user = U.id "
				+ "WHERE U.id = " + id;
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				
				BeanUserFone user = new BeanUserFone();
				
				user.setEmail(result.getString("email"));
				user.setNome(result.getString("nome"));
				user.setNumero(result.getString("numero"));
				
				lista.add(user);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void deleteFonesUser(Long id) {
		
		String sqlFone = "DELETE FROM telefone_user WHERE id_user = " + id;
		String sql = "DELETE FROM userjava WHERE id = " + id;
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sqlFone);
			
			stmt.executeUpdate();
			
			con.commit();
			
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
			
			con.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			try {
				
				con.rollback();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
	}


}
