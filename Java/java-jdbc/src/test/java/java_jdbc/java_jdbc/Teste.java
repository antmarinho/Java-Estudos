package java_jdbc.java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;

public class Teste {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
