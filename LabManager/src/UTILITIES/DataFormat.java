package UTILITIES;

public class DataFormat {
	
	Controller myController;
	
	private String Year;
	private String Month;
	private String Day;
	
	public DataFormat(Controller controller) {
		
		myController = controller;
	}
	
	//GETTERS AND SETTERS

	public void setYear(String year) {
		this.Year = year;
	}

	public void setMonth(String month) {
		this.Month = month;
	}

	public void setDay(String day) {
		this.Day = day;
	}
	
	private String DataCompleta = Year + "-" + Month + "-" + Day;
	
	public String getDataCompleta() {
		return DataCompleta;
	}

}