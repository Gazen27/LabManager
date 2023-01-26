package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;

import java.sql.*;

import DTO.Strumento;

public class StrumentoDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public StrumentoDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
////////////////////////////////////// INSERTING //////////////////////////////////////
	
	//TODO: go into the catch clause.
	public Boolean newStrumento(Strumento strumentoTEMP) {
		
		Integer usage = Integer.parseInt(strumentoTEMP.getMaxUtilizzo());
		
		String queryStart = "INSERT INTO strumento(tipo, descrizioneStrumento, utilizzoMax, postazioneAssegnata) ";
		String values = "VALUES('" + strumentoTEMP.getTipo() + "', '" + strumentoTEMP.getDescrizione() + "', " + usage + ", " + strumentoTEMP.getPostazioneAssegnata() + ");";
		
		try {
			
			statement.executeQuery(queryStart + values);
			return true;
			
		} catch(SQLException e) {
			
			return false;
		}
	}
	
	
	
}