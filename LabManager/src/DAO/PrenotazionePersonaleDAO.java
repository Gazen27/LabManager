package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import DTO.PrenotazionePersonale;

public class PrenotazionePersonaleDAO {
	
	private ConnessioneDB connessioneDB;
	private Statement statement;
	
	Controller myController;
	
	public PrenotazionePersonaleDAO(Controller controller) {
		
		myController = controller;
		
		connessioneDB = ConnessioneDB.getConnessione();
		statement = connessioneDB.getStatement();
	}
	
	
////////////////////////////////////// DELETE / UPDATING //////////////////////////////////////	
	
	public void deletePrenotazione(PrenotazionePersonale prenotazione) {
		
		try {
			
			statement.executeQuery("DELETE FROM prenotazioni WHERE codicePrenotazione = " + prenotazione.getCodicePrenotazione());
			
		} catch(SQLException e) {
			
			e.getMessage();
		}
	}
	
	
	public void updatePrenotazione(Integer codice, Integer tempoAggiornato, LocalDate dataAggiornata) {
		
		try {
			
			statement.executeQuery("UPDATE prenotazioni SET oreprenotate = " + tempoAggiornato + ", dataprenotazione = '" + dataAggiornata + "' WHERE codiceprenotazione = " + codice + ";");
			
		} catch(SQLException e) {
			
			e.getMessage();
		}
	}
	
////////////////////////////////////// SELECTING ////////////////////////////////////// 
	
	public Vector<PrenotazionePersonale> getAllPrenotazioni(String matricola){
		
		Vector<PrenotazionePersonale> allPrenotazioni = new Vector<PrenotazionePersonale>();
		PrenotazionePersonale prenotazione;
		
		String data = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String strumentoCompleto;
		String laboratorioSede;
		
		String query1 = "SELECT pr.codicePrenotazione, pr.dataPrenotazione, pr.oreprenotate, sc.codstrumento, sc.tipo, sc.postazioneassegnata, sc.laboratoriopostazione, sc.nome, sc.utilizzoMax ";
		String query2 = "FROM prenotazioni pr INNER JOIN strumentoCompleto sc ON pr.strumentoPrenotato = sc.codstrumento ";
		String query3 = "WHERE pr.matricolaprenotata = '" + matricola + "';";
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2 + query3);
			
			while(rs.next()) {
				
				prenotazione = new PrenotazionePersonale();
				
				data = rs.getDate("dataPrenotazione").toString();
				
				//CONVERTO DA TIPO STRING A TIPO LOCALDATE
				LocalDate dataConvertita = LocalDate.parse(data, formatter);
				
				strumentoCompleto = "00" + rs.getInt("codStrumento") + " - " + rs.getString("tipo");
				laboratorioSede = rs.getString("laboratoriopostazione") + " - " + rs.getString("nome");
				
				prenotazione.setCodicePrenotazione(rs.getInt("codicePrenotazione"));
				prenotazione.setDataPrenotazione(dataConvertita);
				prenotazione.setTempoPrenotato(rs.getInt("oreprenotate"));
				prenotazione.setStrumentoCompleto(strumentoCompleto);
				prenotazione.setPostazioneAssegnata(rs.getInt("postazioneassegnata"));
				prenotazione.setLaboratorioSede(laboratorioSede);
				
				prenotazione.setTempoMaxStrumento(rs.getInt("utilizzoMax"));
				
				allPrenotazioni.add(prenotazione);
			}
			
			return allPrenotazioni;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return allPrenotazioni;
		}
	}
	
	
	public PrenotazionePersonale getPrenotazioneSelezionata(String codice) {
		
		Integer cod = Integer.parseInt(codice);
		
		String data = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String strumentoCompleto;
		String laboratorioSede;
		
		PrenotazionePersonale prenotazione = new PrenotazionePersonale();
		
		String query1 = "SELECT pr.dataPrenotazione, pr.oreprenotate, sc.codstrumento, sc.tipo, sc.postazioneassegnata, sc.laboratoriopostazione, sc.nome, sc.utilizzoMax ";
		String query2 = "FROM prenotazioni pr INNER JOIN strumentoCompleto sc ON pr.strumentoPrenotato = sc.codstrumento ";
		String query3 = "WHERE pr.codicePrenotazione = " + codice;
		
		try {
			
			ResultSet rs = statement.executeQuery(query1 + query2 + query3);
			
			rs.next();
			
			data = rs.getDate("dataPrenotazione").toString();
			
			//CONVERTO DA TIPO STRING A TIPO LOCALDATE
			LocalDate dataConvertita = LocalDate.parse(data, formatter);
			
			strumentoCompleto = "00" + rs.getInt("codStrumento") + " - " + rs.getString("tipo");
			laboratorioSede = rs.getString("laboratoriopostazione") + " - " + rs.getString("nome");
			
			prenotazione.setCodicePrenotazione(cod);
			prenotazione.setDataPrenotazione(dataConvertita);
			prenotazione.setTempoPrenotato(rs.getInt("oreprenotate"));
			prenotazione.setStrumentoCompleto(strumentoCompleto);
			prenotazione.setPostazioneAssegnata(rs.getInt("postazioneassegnata"));
			prenotazione.setLaboratorioSede(laboratorioSede);
			
			prenotazione.setTempoMaxStrumento(rs.getInt("utilizzoMax"));
			
			return prenotazione;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			return prenotazione;
		}
	}
	
}