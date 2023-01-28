package DTO;

import java.time.LocalDate;


public class PrenotazionePersonale {
	
	private Integer codicePrenotazione;
	private String strumentoCompleto;
	private Integer postazioneAssegnata;
	private String laboratorioSede;
	private LocalDate dataPrenotazione;
	private Integer tempoPrenotato;
	
	public PrenotazionePersonale() {
		
	}
	
		
	public Integer getCodicePrenotazione() {
		return codicePrenotazione;
	}

	public void setCodicePrenotazione(Integer codicePrenotazione) {
		this.codicePrenotazione = codicePrenotazione;
	}

	public Integer getPostazioneAssegnata() {
		return postazioneAssegnata;
	}

	public void setPostazioneAssegnata(Integer postazioneAssegnata) {
		this.postazioneAssegnata = postazioneAssegnata;
	}

	public String getStrumentoCompleto() {
		return strumentoCompleto;
	}


	public void setStrumentoCompleto(String strumentoCompleto) {
		this.strumentoCompleto = strumentoCompleto;
	}


	public String getLaboratorioSede() {
		return laboratorioSede;
	}


	public void setLaboratorioSede(String laboratorioSede) {
		this.laboratorioSede = laboratorioSede;
	}


	public LocalDate getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Integer getTempoPrenotato() {
		return tempoPrenotato;
	}

	public void setTempoPrenotato(Integer tempoPrenotato) {
		this.tempoPrenotato = tempoPrenotato;
	}
}
