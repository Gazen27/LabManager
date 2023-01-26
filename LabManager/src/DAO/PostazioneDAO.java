package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;
import DTO.Postazione;


import java.sql.*;
import java.util.Vector;

public class PostazioneDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public PostazioneDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
////////////////////////////////////// INSERTING / UPDATING //////////////////////////////////////
	
	public void newPostazione(Postazione postazione) {
		
		String query1 = "INSERT INTO postazione(laboratorioPostazione, sedePostazione, maxStrumenti) VALUES('";
		String query2 = postazione.getLaboratorioAppartenenza() + "', " + postazione.getSedeAppartenenza() + ", " + postazione.getMaxStrumenti() + ");";
		
		try {
			
			statement.executeQuery(query1 + query2);
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
	}
	
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Vector<Integer> getAllPostazioniAssociate(String responsabile) {
		
		Vector<Integer> codice = new Vector<Integer>();
		
		String query1 = "select po.codpostazione from postazione po inner join locazione l ";
		String query2 = "on po.laboratoriopostazione = l.tlaboratorio and po.sedepostazione = l.csede ";
		String query3 = "and l.responsabile = '" + responsabile + "';";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2 + query3);
			
			while(rs.next()) {
				
				codice.add(rs.getInt("codpostazione"));
			}
			
			return codice;
			
		} catch(SQLException e) {
			
			return codice;
		}
	}
}
