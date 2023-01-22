package UTILITIES;

import java.sql.*;

public class ConnessioneDB {
	
	private Connection connection;
	private static ConnessioneDB istanza;
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
			System.out.println("Connessione al database fallita.");
		}
		
		try {

			statement = connection.createStatement();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public static ConnessioneDB getConnessione() {

		if (istanza == null) {
			
			istanza = new ConnessioneDB();
		}

		return istanza;
	}

	public Statement getStatement() {
		
		return statement;
	}

}
