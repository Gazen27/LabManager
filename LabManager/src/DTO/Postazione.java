package DTO;

import UTILITIES.Controller;

public class Postazione {
	
	Controller myController;
	
	private String LaboratorioAppartenenza;
	private String SedeAppartenenza;
	private Integer maxStrumenti;
	private Integer currentStrumenti;
	
	public Postazione(Controller controller) {
	
		myController = controller;
	
	}
	
	public String getLaboratorioAppartenenza() {
		
		return this.LaboratorioAppartenenza;
	}
	
	public void setLaboratorioAppartenenza(String laboratorioAppartenenza) {
		
		this.LaboratorioAppartenenza = laboratorioAppartenenza;
	}
	
	public String getSedeAppartenenza() {
		
		return this.SedeAppartenenza;
	}

	public void setSedeAppartenenza(String sedeAppartenenza) {
		
		this.SedeAppartenenza = sedeAppartenenza;
	}
	
	public Integer getMaxStrumenti() {
		
		return this.maxStrumenti;
	}
	
	public void setMaxStrumenti(Integer maxStrumenti) {
		
		this.maxStrumenti = maxStrumenti;
	}
	
	public Integer getCurrentStrumenti() {
		
		return this.currentStrumenti;
	}

	public void setCurrentStrumenti(Integer currentStrumenti) {
		
		this.currentStrumenti = currentStrumenti;
	}
}
