package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String banco = "jdbc:postgresql://localhost:5432/systemsgs_gui?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection con = null;
	
	static {
		conectar();
	}
	
	public void SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if (con == null) {
				Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(banco, user, password);
				con.setAutoCommit(false);
			}
			
		}catch (Exception e) {
			throw new RuntimeException("Erro ao Conectar com o Banco de Dados");
		}
	}
	
	public static Connection getConnection() {
		return con;
	}

}
