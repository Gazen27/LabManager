package UTILITIES;

import DTO.Tecnico;

public class Session {
	
	Controller myController;
	private Tecnico user;
	
	public Session(Controller controller, Tecnico user) {
		
		myController = controller;
		
		this.user = user;
		
	}
	
	public String getUserMatricola() {
		
		return user.getMatricola();
	}
	
	public String getNomeCompleto() {
		
		String nomeCompleto = user.getNome() + " " + user.getCognome();
		return nomeCompleto;
	}

}
