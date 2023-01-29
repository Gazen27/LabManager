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
	
	
//	public Storico getStoricoStrumento(Integer codiceStrumento) {
//		
//		Storico storico = new Storico();
//		
//		String query1 = "SELECT "
//		
//		try {
//			
//			ResultSet rs = statement.executeQuery("SELECT ");
//		}
//	}
}