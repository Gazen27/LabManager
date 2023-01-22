package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import UTILITIES.Controller;
import UTILITIES.DataFormat;

public class DataComponent extends JComponent {
	
	Controller myController;
	JTextField giornoField;
	JTextField meseField;
	JTextField annoField;

	public DataComponent(String textToShow, Controller controller) {
		
		myController = controller;
		
		setLayout(null);

		JLabel dataLabel = new JLabel(textToShow);
		dataLabel.setBounds(65, 280, 160, 22);
		dataLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		giornoField = new JTextField("GG");
		giornoField.setBounds(65, 310, 80, 30);
		giornoField.setFont(new Font("Arial", Font.ITALIC,  17));
		giornoField.setForeground(Color.GRAY);
	
		giornoField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				giornoField.setText("");
				giornoField.setForeground(Color.black);
				giornoField.setFont(new Font("Arial", Font.PLAIN, 17));
			}
		});
		
		meseField = new JTextField("MM");
		meseField.setBounds(145, 310, 80, 30);
		meseField.setFont(new Font("Arial", Font.ITALIC,  17));
		meseField.setForeground(Color.GRAY);
		
		meseField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				meseField.setText("");
				meseField.setForeground(Color.black);
				meseField.setFont(new Font("Arial", Font.PLAIN, 17));
			}
		});
		
		annoField = new JTextField("YYYY");
		annoField.setBounds(225, 310, 80, 30);
		annoField.setFont(new Font("Arial", Font.ITALIC,  17));
		annoField.setForeground(Color.GRAY);
		
		annoField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				annoField.setText("");
				annoField.setForeground(Color.black);
				annoField.setFont(new Font("Arial", Font.PLAIN, 17));
			}
		});
		
		add(dataLabel);
		add(giornoField);
		add(meseField);
		add(annoField);
		
//		DataFormat dataTemp = new DataFormat(myController);
//		dataTemp.setDay(giornoField.getText());
//		dataTemp.setMonth(meseField.getText());
//		dataTemp.setYear(annoField.getText());
	}
	
	public String getGiorno() {
		return giornoField.getText();
	}

	public String getMese() {
		return meseField.getText();
	}
	
	public String getAnno() {
		return annoField.getText();
	}
	
	public String getDataCompleta() {
		return this.getGiorno() + "-" + this.getMese() + "-" + this.getAnno();
	}

}