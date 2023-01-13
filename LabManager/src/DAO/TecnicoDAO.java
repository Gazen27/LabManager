package DAO;

import UTILITIES.ConnessioneDB;
import DTO.Tecnico;

import java.sql.*;

public class TecnicoDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	private ResultSet resultSet;
	
	public TecnicoDAO() {
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
	public void creaTecnico(Tecnico tecnico) {
		
		String queryStart = "INSERT INTO tecnico (matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email) VALUES ('";
		String queryValues1 = tecnico.getMatricola() + "' ,'" + tecnico.getPassword() + "' ,'" + tecnico.getNome() + "' ,'" + tecnico.getCognome() + "' ,'";
		String queryValues2 = tecnico.getDataNascita() + "' ,'" + tecnico.getSesso() + "' ,'" + tecnico.getCodiceFiscale() + "' ,'" + tecnico.getTelefono() + "' ,'" + tecnico.getEmail();
		String queryEnd = "')";
		
		try {
			
			statement.execute(queryStart + queryValues1 + queryValues2 + queryEnd);
				
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	//DA RIVEDERE
	public Boolean checkExistingUserRegistration(Tecnico tecnico) {
		
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM tecnico WHERE codicefiscale = '" + tecnico.getCodiceFiscale() + "'");
			rs.next();
			
			if(rs.getString("codicefiscale") == null) {
				
				return true;
				
			} else { return false; }
			
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			return true;
		}
	}
	
	public Boolean checkExistingMatricola(String currentMatricola) {
		
		try {
			
			statement.execute("SELECT * FROM tecnico WHERE matricola = '" + currentMatricola + "'");
			return true;
			
		} catch(SQLException e) {
			
			return false;
		}
	}

}
