package DAO;

import UTILITIES.ConnessioneDB;
import UTILITIES.Controller;
import DTO.Prenotazione;
import DTO.Sede;

import java.sql.*;
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
			
			e.printStackTrace();
		}
		
	}
	
}