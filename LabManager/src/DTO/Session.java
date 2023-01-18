package DTO;

import UTILITIES.Controller;

public class Session {
	
	Controller myController;
	private Tecnico user;
	
	public Session(Controller controller, Tecnico user) {
		
		myController = controller;
		
		this.user = user;
		
	}
	
	public String getUserMatricola() {
		
		return user.Matricola;
	}
	
	public String getNomeCompleto() {
		
		String nomeCompleto = user.getNome() + " " + user.getCognome();
		return nomeCompleto;
	}

}
