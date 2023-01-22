package DTO;

import UTILITIES.Controller;
import UTILITIES.DataFormat;

public class Tecnico {
	
	Controller myController;
	
	String Nome;
	String Cognome;

	String DataNascita;
	
	char sesso;
	String CodiceFiscale;

	String Telefono;
	String Email;
	
	String Matricola;
	String Password = "passwordProva11";
	
	
	public Tecnico(Controller controller) {
		
		myController = controller;
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getDataNascita() {
		return DataNascita;
	}

	public void setDataNascita(String dataNascita) {
		DataNascita = dataNascita;
	}

	public char getSesso() {
		return sesso;
	}

	public void setSesso(char sesso) {
		this.sesso = sesso;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		Matricola = matricola;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
