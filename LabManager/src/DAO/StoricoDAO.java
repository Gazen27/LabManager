package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StoricoDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public StoricoDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
}