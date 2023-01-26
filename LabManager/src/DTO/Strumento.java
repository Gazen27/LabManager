package DTO;

import UTILITIES.Controller;

public class Strumento {

	private String Tipo;
	private Integer MaxUtilizzo; 
	private Integer PostazioneAssegnata;
	private String Descrizione;
	
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

	public Integer getMaxUtilizzo() {
		return MaxUtilizzo;
	}

	public void setMaxUtilizzo(Integer maxUtilizzo) {
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
	
}
