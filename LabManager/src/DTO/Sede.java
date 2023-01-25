package DTO;

import UTILITIES.Controller;

public class Sede {
	
	Controller myController;
	
	private String codiceSede;
	private String nomeSede;
	
	public Sede(Controller controller) {
		
		myController = controller;
	}

	public String getCodiceSede() {
		return this.codiceSede;
	}

	public void setCodiceSede(String codiceSede) {
		this.codiceSede = codiceSede;
	}

	public String getNomeSede() {
		return this.nomeSede;
	}

	public void setNomeSede(String nomeSede) {
		this.nomeSede = nomeSede;
	}
	
}
