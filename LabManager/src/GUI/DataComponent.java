package GUI;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import UTILITIES.Controller;

public class DataComponent extends JComponent {
	
	Controller myController;
	
	private JComboBox giornoBox;
	private JComboBox meseBox;
	private JTextField annoField;

	public DataComponent(String textToShow, Controller controller) {
		
		myController = controller;
		
		setLayout(null);

		JLabel dataLabel = new JLabel(textToShow);
		dataLabel.setBounds(65, 280, 160, 22);
		dataLabel.setFont(new Font("Arial", Font.BOLD, 20));
		add(dataLabel);
		
		String[] dayList = {"GG", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		giornoBox = new JComboBox(dayList);
		giornoBox.setBounds(65, 310, 70, 30);
		giornoBox.setFont(new Font("Arial", Font.PLAIN, 17));
		giornoBox.setFocusable(false);
		add(giornoBox);
		
		String[] monthList = {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
		meseBox = new JComboBox(monthList);
		meseBox.setBounds(145, 310, 70, 30);
		meseBox.setFont(new Font("Arial", Font.PLAIN, 17));
		meseBox.setFocusable(false);
		add(meseBox);
		
		annoField = new JTextField();
		annoField.setBounds(225, 310, 80, 30);
		annoField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(annoField);
		
	}
	
	public String getGiorno() {
		return (String)giornoBox.getSelectedItem();
	}

	public String getMese() {
		return (String)meseBox.getSelectedItem();
	}
	
	public String getAnno() {
		return annoField.getText();
	}
	
	public String getDataCompleta() {
		return this.getGiorno() + "-" + this.getMese() + "-" + this.getAnno();
	}
	
	public void setGiorno(String giorno) {
		
		this.giornoBox.setSelectedItem(giorno);
	}
	
	public void setMese(String mese) {
		
		this.meseBox.setSelectedItem(mese);
	}
	
	public void setAnno(String anno) {
		
		this.annoField.setText(anno);
	}

}