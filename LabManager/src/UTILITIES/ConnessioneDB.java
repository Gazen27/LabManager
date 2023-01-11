package UTILITIES;

import java.sql.*;

public class ConnessioneDB {
	
	private Connection connection;
	private ConnessioneDB istanza;
	private Statement statement;
	
	private ConnessioneDB() {
		
		statement = null;
		
		
		try {
			
			String url = "jdbc:postgresql://localhost:5432/LabManagerDB";
			String user = "postgres";
			String password = "6540";
			
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Tentativo di connessione fallito");

		}
	}

}
