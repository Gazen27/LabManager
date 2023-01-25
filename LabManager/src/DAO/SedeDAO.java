package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;

import DTO.Sede;

import java.sql.*;
import java.util.Vector;

public class SedeDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public SedeDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
		
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Vector<Sede> allSedi(){
		
		Vector<Sede> tutteSedi = new Vector<Sede>();
		
		Sede newSede = new Sede(myController);
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT codsede, nome FROM sede");
			
			while(rs.next()) {
				
				newSede.setCodiceSede(rs.getString("codsede"));
				newSede.setNomeSede("nome");
				
				tutteSedi.add(newSede);
			}
			
			return tutteSedi;
			
		} catch(SQLException e) {
			
			return tutteSedi;
		}
	}
	
	
	public Vector<String> allNomiSedi(){
		
		Vector<String> tutteSedi = new Vector<String>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT nome FROM sede");
			
			while(rs.next()) {
				
				tutteSedi.add(rs.getString("nome"));
			}
			
			return tutteSedi;
			
		} catch(SQLException e) {
			
			return tutteSedi;
		}
	}
}