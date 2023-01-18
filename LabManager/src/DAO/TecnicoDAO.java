package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;
import DTO.Tecnico;
import GUI.PasswordRecoveryPanel;

import java.sql.*;
import java.util.Vector;

public class TecnicoDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public TecnicoDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
////////////////////////////////////// INSERTING //////////////////////////////////////
	
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
	
	
	public Boolean nuovaPassword(PasswordRecoveryPanel recovery) {
		
		try {
			
			statement.execute("UPDATE tecnico SET pass = '" + recovery.getNewPasswordInserted() + "' WHERE matricola = '" + recovery.getMatricolaInserted() + "'");
			return true;
			
		} catch(SQLException e) {
			
			recovery.datiErratiMancanti.setVisible(true);
			return false;
		}
	}

////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Tecnico getSingoloTecnico(String matricolaInserted) {

		Tecnico currentTecnico = new Tecnico(myController);
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM tecnico t WHERE t.matricola = '" + matricolaInserted + "'");	
			
			rs.next();
			currentTecnico.setNome(rs.getString("nome"));
			currentTecnico.setCognome(rs.getString("cognome"));
			currentTecnico.setMatricola(rs.getString("matricola"));
			currentTecnico.setPassword(rs.getString("pass"));
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return currentTecnico;
		
	}
	
	public Vector<Tecnico> getAllTecnici(){

		Vector<Tecnico> tuttiTecnici = new Vector<Tecnico>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM tecnico t ORDER BY t.matricola");
			
			while(rs.next()) {
				
				Tecnico t = new Tecnico(myController);
				t.setMatricola(rs.getString("matricola"));
				t.setPassword(rs.getString("pass"));
				t.setNome(rs.getString("nome"));
				t.setCognome(rs.getString("cognome"));
				tuttiTecnici.add(t);
			}
			
			return tuttiTecnici;
			
		} catch(SQLException e) {
			e.getMessage();
			return tuttiTecnici;
		}
			
	}
	
	
	public Boolean checkExistingMatricola(String currentMatricola) {
		
		Vector<String> tutteMatricole = new Vector<String>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT * FROM tecnico t ORDER BY t.matricola");
			
			while(rs.next()) {
				
				tutteMatricole.add(rs.getString("matricola"));
			}
			
			return tutteMatricole.contains(currentMatricola);
			
		} catch(SQLException e) {
			
			return false;
		}
	}
	
	
	public Boolean checkMatchingCredentials(String matricolaInserted, String passwordInserted) {
		
		if(this.checkExistingMatricola(matricolaInserted)) {
			
			String passwordToCheck;
			
			try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM tecnico t WHERE t.matricola = '" + matricolaInserted + "'");
				
				rs.next();
				passwordToCheck = rs.getString("pass");
				
				if(passwordToCheck.equals(passwordInserted)) {
					
					return true;
					
				} else { return false; }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
			
		} else { return false; }
		
	}
	
	
	public Boolean checkCorrectRecoveryInfo(PasswordRecoveryPanel recovery) {
		
		if(this.checkExistingMatricola(recovery.getMatricolaInserted())){
			
			try {
				
				ResultSet rs = statement.executeQuery("SELECT * FROM tecnico t WHERE t.matricola = '" + recovery.getMatricolaInserted() + "'");
				
				rs.next();
				if(recovery.getCFInserted().equals(rs.getString("codicefiscale"))) {
					if(recovery.getEmailInserted().equals(rs.getString("email"))) {
						if(recovery.getTelefonoInserted().equals(rs.getString("telefono"))) {
							
							return true;
							
						} else { return false; }
						
					} else { return false; }
					
				} else { return false; }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
			
		} else { return false; }
	}

}
