package jdbc;

public class DAOteste {
	
	public static void main(String[] args) {
		
		String sql = "INSERT INTO pessoas(nome) VALUES (?)";
		
		DAO dao = new DAO();
		
		System.out.println(dao.incluir(sql, "joao da silva"));
		System.out.println(dao.incluir(sql, "maria do carmo"));
		System.out.println(dao.incluir(sql, "pedro pascal"));
		System.out.println(dao.incluir(sql, "antonio carlos"));
		
		dao.close();
	}

}
