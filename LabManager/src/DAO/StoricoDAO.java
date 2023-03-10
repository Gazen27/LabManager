package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import DTO.Storico;

public class StoricoDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public StoricoDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
////////////////////////////////////// UPDATING //////////////////////////////////////
	
	public void update() {
		
		try {
			
			statement.executeQuery("CALL aggiorna_conclusa();");
			
		} catch(SQLException e) {
			
			e.getMessage();
		}
	}
	
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Integer utilizzoMensile(Integer codiceStrumento) {
		
		Integer tempo = 0;
		LocalDate today = LocalDate.now();
		
		Integer mese = today.getMonthValue();
		
		String query1 = "SELECT SUM(tempoutilizzo) FROM storico ";
		String query2 = "WHERE strumentostorico = " + codiceStrumento + " AND EXTRACT(MONTH FROM datastorico) = '" + mese + "';";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2);
			
			rs.next();
			tempo = rs.getInt("sum");
			
			
			return tempo;
			
		} catch (SQLException e) {
			
			e.getMessage();
			return tempo;
		}
	}
	
	
	public Integer utilizzoAnnuale(Integer codiceStrumento) {
		
		Integer tempo = 0;
		LocalDate today = LocalDate.now();
		
		Integer anno = today.getYear();
		
		String query1 = "SELECT SUM(tempoutilizzo) FROM storico ";
		String query2 = "WHERE strumentostorico = " + codiceStrumento + " AND EXTRACT(YEAR FROM datastorico) = '" + anno + "';";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2);
			
			rs.next();
			tempo = rs.getInt("sum");
			
			return tempo;
			
		} catch (SQLException e) {
			
			e.getMessage();
			return tempo;
		}
	}
	
	
	public String topUtilizzatoreMese(Integer codiceStrumento) {
		
		LocalDate today = LocalDate.now();
		Integer mese = today.getMonthValue();
		
		String topUtilizzatore = "X";
		
		String query1 = "SELECT utilizzatore FROM storico WHERE strumentostorico = " + codiceStrumento + " AND EXTRACT(MONTH FROM datastorico) = '";
		String query2 = mese + "' GROUP BY utilizzatore ORDER BY SUM(tempoUtilizzo) DESC LIMIT 1;";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2);
			
			rs.next();
			topUtilizzatore = rs.getString("utilizzatore");
			return topUtilizzatore;
			
		} catch(SQLException e) {
			
			e.getMessage();
			return topUtilizzatore;
		}
	}
	
	
	public String topUtilizzatoreAnno(Integer codiceStrumento) {
		
		LocalDate today = LocalDate.now();
		Integer anno = today.getYear();
		
		String topUtilizzatore = "";
		
		String query1 = "SELECT utilizzatore FROM storico WHERE strumentostorico = " + codiceStrumento + " AND EXTRACT(YEAR FROM datastorico) = '";
		String query2 = anno + "' GROUP BY utilizzatore ORDER BY SUM(tempoUtilizzo) DESC LIMIT 1;";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2);
			
			rs.next();
			topUtilizzatore = rs.getString("utilizzatore");
			return topUtilizzatore;
			
		} catch(SQLException e) {
			
			e.getMessage();
			return topUtilizzatore;
		}
	}
}