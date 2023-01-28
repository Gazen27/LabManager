package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;
import DTO.Prenotazione;
import DTO.Sede;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
	
	public void nuovaPrenotazione(Prenotazione prenotazione) {
		
		String queryStart = "INSERT INTO prenotazioni(matricolaPrenotata, strumentoPrenotato, postazionePrenotata, dataPrenotazione, orePrenotate) ";
		String values1 = "VALUES ('" + prenotazione.getMatricolaPrenotata() + "', " + prenotazione.getCodiceStrumentoPrenotato() + ", ";
		String values2 = prenotazione.getCodicePostazionePrenotata() + ", '" + prenotazione.getDataPrenotazione() + "', " + prenotazione.getOrePrenotate() + ");";
		
		try {
			
			statement.executeQuery(queryStart + values1 + values2);
			System.out.println("CIAO");
			
		} catch (SQLException e) {
			
			e.getMessage();	
		}
		
	}
	
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Vector<LocalDate> getAllDatePrenotateScelte(Integer codiceStrumento){
		
		Vector<LocalDate> tutteDate = new Vector<LocalDate>();
		
		String data = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		try {
			
			ResultSet rs = statement.executeQuery("select dataprenotazione from prenotazioni where strumentoprenotato = " + codiceStrumento);
			
			while(rs.next()) {
				
				data = rs.getDate("dataprenotazione").toString();
				
				//CONVERTO DA TIPO STRING A TIPO LOCALDATE
				LocalDate dataConvertita = LocalDate.parse(data, formatter);
				
				tutteDate.add(dataConvertita);
			}
			
			return tutteDate;
			
		} catch(SQLException e) {
			
			return tutteDate;
		}
	}
}