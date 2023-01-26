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
	
	public Boolean newStrumento(Strumento strumentoTEMP) {
		
		String queryStart = "INSERT INTO strumento(tipo, descrizioneStrumento, utilizzoMax, postazioneAssegnata) ";
		String values = "VALUES('" + strumentoTEMP.getTipo() + "', '" + strumentoTEMP.getDescrizione() + "', " + strumentoTEMP.getMaxUtilizzo() + ", " + strumentoTEMP.getPostazioneAssegnata() + ");";
		
		try {
			
			statement.executeQuery(queryStart + values);
			return true;
			
		} catch(SQLException e) {
			
			return false;
		}
	}
}