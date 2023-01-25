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
		
		Integer sede = postazione.getSedeAppartenenza();
		
		String query1 = "INSERT INTO postazione(laboratorioPostazione, sedePostazione, maxStrumenti) VALUES('";
		String query2 = postazione.getLaboratorioAppartenenza() + "', " + postazione.getSedeAppartenenza() + ", " + postazione.getMaxStrumenti() + ");";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2);
			
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
	}
}
