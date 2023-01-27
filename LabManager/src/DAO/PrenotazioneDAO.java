package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;

import DTO.Sede;

import java.sql.*;
import java.util.Vector;

public class PrenotazioneDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public PrenotazioneDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
		
////////////////////////////////////// INSERTING //////////////////////////////////////
	
	
	
}