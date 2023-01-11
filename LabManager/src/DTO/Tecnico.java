package DTO;

import UTILITIES.Controller;
import UTILITIES.DataFormat;

public class Tecnico {
	
	Controller myController;
	
	String Nome;
	String Cognome;
	
	DataFormat dataNascitaFormat = new DataFormat(myController);
	String DataNascita = dataNascitaFormat.getDataCompleta();
	
	char sesso;
	String CodiceFiscale;

	String Telefono;
	String Email;
	
	String Matricola;
	String Password;
	
	String NomeCompleto = Nome + " " + Cognome;
	
	public Tecnico() {
		
	}
	

}
