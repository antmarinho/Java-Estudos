package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserJavaDAO {
	
	private Connection con;
	
	public UserJavaDAO() {
		con = SingleConnection.getConnection();
	}

}
