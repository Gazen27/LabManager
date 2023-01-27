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
	
	
	public Vector<String> allNomiSediIscritto(String matricola){
		
		Vector<String> tutteSedi = new Vector<String>();
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT s.nome FROM sede s INNER JOIN lavora l ON s.codsede = l.codsede WHERE l.matricolaTecnico = '" + matricola + "';");
			
			while(rs.next()) {
				
				tutteSedi.add(rs.getString("nome"));
			}
			
			return tutteSedi;
			
		} catch(SQLException e) {
			
			return tutteSedi;
		}
	}
	
	
	public Integer sedeScelta(String responsabile) {
		
		Integer sede = 0;
		
		try {
			
			ResultSet rs = statement.executeQuery("SELECT l.csede FROM locazione l WHERE l.responsabile = '" + responsabile + "';");
			
			rs.next();
			sede = rs.getInt("csede");
			
			return sede;
			
		} catch (SQLException e) {
			
			e.getMessage();
			return sede;
		}
	}
	
	
}