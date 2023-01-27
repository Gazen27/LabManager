package DTO;

import UTILITIES.Controller;

public class Strumento {

	private Integer codice;

	private String Tipo;
	private String MaxUtilizzo; 
	private Integer PostazioneAssegnata;
	private String Descrizione;
	
	private Integer SedeAssegnata;
	private String LaboratorioAssegnato;

	Controller myController; 
	
	public Strumento(Controller controller) {
		
		myController = controller;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getMaxUtilizzo() {
		return MaxUtilizzo;
	}

	public void setMaxUtilizzo(String maxUtilizzo) {
		MaxUtilizzo = maxUtilizzo;
	}

	public Integer getPostazioneAssegnata() {
		return PostazioneAssegnata;
	}

	public void setPostazioneAssegnata(Integer postazioneAssegnata) {
		PostazioneAssegnata = postazioneAssegnata;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	
	
	public Integer getSedeAssegnata() {
		return this.SedeAssegnata;
	}

	public void setSedeAssegnata(Integer sedeAssegnata) {
		this.SedeAssegnata = sedeAssegnata;
	}

	public String getLaboratorioAssegnato() {
		return this.LaboratorioAssegnato;
	}

	public void setLaboratorioAssegnato(String laboratorioAssegnato) {
		this.LaboratorioAssegnato = laboratorioAssegnato;
	}
	
	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	
}
