package br.edu.utfpr.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;

public class ConnectDataBase {
	
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/biblioteca";
	public static Connection CreateConnection() {
		Properties properties = new Properties();
		properties.setProperty("user","postgres" );
		properties.setProperty("password", "root");
		Connection conexao = null;
		
		try {
			conexao = DriverManager.getConnection(DATABASE_URL,properties); 
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return conexao;
	}

}
