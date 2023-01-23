package DTO;

import UTILITIES.Controller;
import UTILITIES.DataFormat;

public class Tecnico {
	
	Controller myController;
	
	private String Nome;
	private String Cognome;

	private String DataNascita;
	
	private char sesso;
	private String CodiceFiscale;

	private String Telefono;
	private String Email;
	
	private String Matricola;
	private String Password;
	
	
	public Tecnico(Controller controller) {
		
		myController = controller;
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		this.Cognome = cognome;
	}

	public String getDataNascita() {
		return DataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.DataNascita = dataNascita;
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
		this.CodiceFiscale = codiceFiscale;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getMatricola() {
		return Matricola;
	}

	public void setMatricola(String matricola) {
		this.Matricola = matricola;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
}
