package DTO;

import UTILITIES.Controller;

public class Laboratorio {
	
	Controller myController;
	
	private String Codice;
	private String Tipo;
	private String Sede;
	private String NumeroTecnici;
	
	private String Descrizione;
	
	private String Responsabile;
	
	public Laboratorio(Controller controller) {
		
		myController = controller;
		
	}
	
	public void setCodice(String codice) {
		
		this.Codice = codice;
	}
	
	public String getCodice() {
		
		return this.Codice;
	}
	
	public void setTipo(String tipo) {
		
		this.Tipo = tipo;
	}
	
	public String getTipo() {
		
		return this.Tipo;
	}
	
	public void setSede(String sede) {
		
		this.Sede = sede;
	}
	
	public String getSede(){
		
		return this.Sede;
	}
	
	public void setNumeroTecnici(String numeroTecnici) {
		
		this.NumeroTecnici = numeroTecnici;
	}
	
	public String getNumeroTecnici() {
		
		return this.NumeroTecnici;
	}
	
	public void setDescrizione(String descrizione) {
		
		this.Descrizione = descrizione;
	}
	
	public String getDescrizione() {
		
		return this.Descrizione;
	}
	
	
	public void setResponsabile(String responsabile) {
		
		this.Responsabile = responsabile;
	}
	
	public String getResponsabile() {
		
		return this.Responsabile;
	}
	
}
