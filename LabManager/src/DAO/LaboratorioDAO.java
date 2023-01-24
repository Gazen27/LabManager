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
	

////////////////////////////////////// INSERTING / DELETING / UPDATING //////////////////////////////////////
	
	public void iscrizioneTecnico(String matricola, String codice, String tipo) {
		
		Integer cod = Integer.parseInt(codice);
		
		String values = "('" + matricola + "', " + cod +", '" + tipo +"');";
		
		try {
			
			ResultSet rs = statement.executeQuery("INSERT INTO lavora(matricolaTecnico, codSede, tipo) VALUES" + values);
			
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
	}
	
	
	public void cancellaIscrizione(String matricola, String sede, String tipo) {
		
		Integer cod = Integer.parseInt(sede);
		
		try {
			
			ResultSet rs = statement.executeQuery("DELETE FROM lavora WHERE matricolaTecnico = '" + matricola + "' AND codSede = '" + cod + "' AND tipo = '" + tipo +"';");
			
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
	}
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Vector<Laboratorio> getAllLaboratori() {
		
		Vector<Laboratorio> tuttiLaboratori = new Vector<Laboratorio>();
		
		try {
			
			Integer codice;
			Integer numero;
			
			String queryStart = "select l.tlaboratorio, l.csede, s.nome, l.numerotecnici, l.numeropostazioni, l.responsabile ";
			String queryMiddle = "from locazione l, sede s where ";
			String queryEnd = "l.csede=s.codsede order by l.csede;";
			
			ResultSet rs = statement.executeQuery(queryStart + queryMiddle + queryEnd);
			
			while(rs.next()) {
				
				Laboratorio lab = new Laboratorio(myController);
				
				codice = rs.getInt("csede");
				numero = rs.getInt("numerotecnici");
				
				lab.setCodice(codice.toString());
				lab.setTipo(rs.getString("tlaboratorio"));
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
			
			String queryStart = "select l.csede, l.tlaboratorio, u.nome, l.numerotecnici, u.descrizione from locazione l ";
			String query1 = "INNER JOIN ( select * from laboratorio, sede) AS u ";
			String query2 = "ON u.tipo = l.tlaboratorio AND u.codsede = l.csede ";
			String queryEnd = "WHERE u.codsede = " + codice + " AND u.tipo = '" + tipo + "';";
			
			ResultSet rs = statement.executeQuery(queryStart + query1 + query2 + queryEnd);
			
			while(rs.next()) {
				
				codice = rs.getInt("csede");
				numero = rs.getInt("numerotecnici");
				
				lab.setCodice(codice.toString());
				lab.setTipo(rs.getString("tlaboratorio"));
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
	
	
	public Boolean isIscritto(String matricola, String codice, String tipo) {
		
		Integer cod = Integer.parseInt(codice);
		
		String query1 = "SELECT l.matricolaTecnico from lavora l ";
		String query2 = "where matricolaTecnico = '" + matricola + "' and codSede = " + cod +" and tipo = '" + tipo + "';";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2);
			
			rs.next();
			
			if(matricola.equals(rs.getString("matricolaTecnico"))) {
				
				return true;
				
			} else { return false; }
			
		} catch(SQLException e) {
			
			return false;
		}
	}
}