package DTO;

public class Storico {
	
	private Integer codiceStrumento;
	private String tipoStrumento;
	private Integer utilizzoMese;
	private Integer utilizzoAnno;
	
	private String topUtilizzatoreMese;
	private String topUtilizzatoreAnno;
	
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

	public String getTopUtilizzatoreMese() {
		return topUtilizzatoreMese;
	}

	public void setTopUtilizzatoreMese(String topUtilizzatoreMese) {
		this.topUtilizzatoreMese = topUtilizzatoreMese;
	}

	public String getTopUtilizzatoreAnno() {
		return topUtilizzatoreAnno;
	}

	public void setTopUtilizzatoreAnno(String topUtilizzatoreAnno) {
		this.topUtilizzatoreAnno = topUtilizzatoreAnno;
	}
	
}
