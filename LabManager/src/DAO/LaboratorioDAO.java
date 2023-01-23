package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;
import DTO.Laboratorio;
import DTO.Tecnico;

import java.sql.*;
import java.util.Vector;

public class LaboratorioDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public LaboratorioDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Vector<Laboratorio> getAllLaboratori() {
		
		Vector<Laboratorio> tuttiLaboratori = new Vector<Laboratorio>();
		
		try {
			
			Integer codice;
			Integer numero;
			
			String queryStart = "select u.codsede, u.tipo, u.nome, u.numerotecnici from locazione l ";
			String queryMiddle = "INNER JOIN ( select * from laboratorio, sede) AS u ";
			String queryEnd = "ON u.codlab = l.claboratorio AND u.codsede = l.csede;";
			
			ResultSet rs = statement.executeQuery(queryStart + queryMiddle + queryEnd);
			
			while(rs.next()) {
				
				Laboratorio lab = new Laboratorio(myController);
				
				codice = rs.getInt("codsede");
				numero = rs.getInt("numerotecnici");
				
				lab.setCodice(codice.toString());
				lab.setTipo(rs.getString("tipo"));
				lab.setSede(rs.getString("nome"));
				lab.setNumeroTecnici(numero.toString());
				
				tuttiLaboratori.add(lab);

			}
			
			return tuttiLaboratori;
			
		} catch(SQLException e) {
			e.getMessage();
			return tuttiLaboratori;
		}
	}
	
	
	public Laboratorio getSingoloLaboratorio(String cod, String tipo) {
		
		Laboratorio lab = new Laboratorio(myController);
		
		try {
			
			Integer codice = Integer.parseInt(cod);
			Integer numero;
			
			String queryStart = "select u.codsede, u.tipo, u.nome, u.numerotecnici, u.descrizione from locazione l ";
			String query1 = "INNER JOIN ( select * from laboratorio, sede) AS u ";
			String query2 = "ON u.codlab = l.claboratorio AND u.codsede = l.csede ";
			String queryEnd = "WHERE u.codsede = " + codice + " AND u.tipo = '" + tipo + "';";
			
			ResultSet rs = statement.executeQuery(queryStart + query1 + query2 + queryEnd);
			
			while(rs.next()) {
				
				codice = rs.getInt("codsede");
				numero = rs.getInt("numerotecnici");
				
				lab.setCodice(codice.toString());
				lab.setTipo(rs.getString("tipo"));
				lab.setSede(rs.getString("nome"));
				lab.setNumeroTecnici(numero.toString());
				lab.setDescrizione(rs.getString("descrizione"));
			}
			
			return lab;
			
		} catch(SQLException e) {
			
			e.getMessage();
			return lab;
		}
	}
}