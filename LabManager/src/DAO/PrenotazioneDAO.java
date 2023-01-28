package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;
import DTO.Prenotazione;
import DTO.Sede;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
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
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
		
	}
	
	
////////////////////////////////////// SELECTING //////////////////////////////////////
	
	public Vector<LocalDate> getAllDatePrenotateScelte(Integer codiceStrumento){
		
		Vector<LocalDate> tutteDate = null;
		
		Date data = null;
		
		try {
			
			ResultSet rs = statement.executeQuery("select dataprenotazione from prenotazioni where strumentoprenotato = " + codiceStrumento);
			
			while(rs.next()) {
				
				data = rs.getDate("dataprenotazione");
				
				//CONVERTO DA TIPO DATE A TIPO LOCALDATE
				LocalDate dataConvertita = LocalDate.ofInstant(data.toInstant(), ZoneId.systemDefault());
				
				tutteDate.add(dataConvertita);
			}
			
			return tutteDate;
			
		} catch(SQLException e) {
			
			return tutteDate;
		}
	}
}