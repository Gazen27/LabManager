package DTO;

import java.time.LocalDate;

public class Prenotazione {
	
	private String matricolaPrenotata;
	private Integer codiceStrumentoPrenotato;
	private Integer codicePostazionePrenotata;
	
	private LocalDate dataPrenotazione;
	private Integer orePrenotate;
	
	public Prenotazione() {
		
	}

	public String getMatricolaPrenotata() {
		return matricolaPrenotata;
	}

	public void setMatricolaPrenotata(String matricolaPrenotata) {
		this.matricolaPrenotata = matricolaPrenotata;
	}

	public Integer getCodiceStrumentoPrenotato() {
		return codiceStrumentoPrenotato;
	}

	public void setCodiceStrumentoPrenotato(Integer codiceStrumentoPrenotato) {
		this.codiceStrumentoPrenotato = codiceStrumentoPrenotato;
	}

	public Integer getCodicePostazionePrenotata() {
		return codicePostazionePrenotata;
	}

	public void setCodicePostazionePrenotata(Integer codicePostazionePrenotata) {
		this.codicePostazionePrenotata = codicePostazionePrenotata;
	}

	public LocalDate getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public Integer getOrePrenotate() {
		return orePrenotate;
	}

	public void setOrePrenotate(Integer orePrenotate) {
		this.orePrenotate = orePrenotate;
	}
	
}
