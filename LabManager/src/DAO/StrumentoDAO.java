package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;

import java.sql.*;
import java.util.Vector;

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
	
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	
	public Vector<Strumento> getAllStrumenti() {
		
		Vector<Strumento> tuttiStrumenti = new Vector<Strumento>();
		
		try {
			
			String queryStart = "select s.codstrumento, s.tipo, s.descrizionestrumento, p.laboratorioPostazione, p.sedePostazione ";
			String queryMiddle = "from strumento s inner join postazione p ";
			String queryEnd = "on s.postazioneAssegnata = p.codPostazione;";
			
			ResultSet rs = statement.executeQuery(queryStart + queryMiddle + queryEnd);
			
			while(rs.next()) {
				
				Strumento str = new Strumento(myController);
				
				str.setCodice(rs.getInt("codstrumento"));
				str.setTipo(rs.getString("tipo"));
				str.setSedeAssegnata(rs.getInt("sedePostazione"));
				str.setLaboratorioAssegnato(rs.getString("laboratorioPostazione"));
				str.setDescrizione(rs.getString("descrizionestrumento"));
				
				tuttiStrumenti.add(str);

			}
			
			return tuttiStrumenti;
			
		} catch(SQLException e) {
			
			e.getMessage();
			return tuttiStrumenti;
		}
	}
	
	
	public Vector<Strumento> getAllStrumentiScelti(String sede) {
		
		Vector<Strumento> tuttiStrumentiScelti = new Vector<Strumento>();
		
		try {
			
			String queryStart = "select s.codstrumento, s.tipo, s.descrizionestrumento ";
			String queryMiddle = "from strumento s INNER JOIN postazioneLocazione cp ";
			String queryEnd = "ON s.postazioneAssegnata = cp.codPostazione AND cp.nome = '" + sede + "';";
			
			ResultSet rs = statement.executeQuery(queryStart + queryMiddle + queryEnd);
			
			while(rs.next()) {
				
				Strumento str = new Strumento(myController);
				
				str.setCodice(rs.getInt("codstrumento"));
				str.setTipo(rs.getString("tipo"));
				str.setDescrizione(rs.getString("descrizionestrumento"));
				
				tuttiStrumentiScelti.add(str);

			}
			
			return tuttiStrumentiScelti;
			
		} catch(SQLException e) {
			
			e.getMessage();
			return tuttiStrumentiScelti;
		}
	}
	
}