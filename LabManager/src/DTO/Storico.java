package DTO;

public class Storico {
	
	private Integer codiceStrumento;
	private String tipoStrumento;
	private Integer utilizzoMese;
	private Integer utilizzoAnno;
	private String topUtilizzatore;
	
	public Storico() {
		
	}

	public Integer getCodiceStrumento() {
		return codiceStrumento;
	}

	public void setCodiceStrumento(Integer codiceStrumento) {
		this.codiceStrumento = codiceStrumento;
	}

	public String getTipoStrumento() {
		return tipoStrumento;
	}

	public void setTipoStrumento(String tipoStrumento) {
		this.tipoStrumento = tipoStrumento;
	}

	public Integer getUtilizzoMese() {
		return utilizzoMese;
	}

	public void setUtilizzoMese(Integer utilizzoMese) {
		this.utilizzoMese = utilizzoMese;
	}

	public Integer getUtilizzoAnno() {
		return utilizzoAnno;
	}

	public void setUtilizzoAnno(Integer utilizzoAnno) {
		this.utilizzoAnno = utilizzoAnno;
	}

	public String getTopUtilizzatore() {
		return topUtilizzatore;
	}

	public void setTopUtilizzatore(String topUtilizzatore) {
		this.topUtilizzatore = topUtilizzatore;
	}
	
}
