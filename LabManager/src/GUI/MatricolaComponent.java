package GUI;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MatricolaComponent extends JComponent {
	
	JTextField matricolaField;

	public MatricolaComponent(String textToShow) {
		
		setLayout(null);
		
		JLabel matricolaLabel = new JLabel(textToShow);
		matricolaLabel.setBounds(110, 230, 120, 25);
		matricolaLabel.setFont(new Font("Arial", Font.BOLD, 23));
		matricolaField = new JTextField();
		matricolaField.setBounds(110, 260, 390, 35);
		matricolaField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		add(matricolaLabel);
		add(matricolaField);
	}
	
	public String getMatricola() {
		return matricolaField.getText();
	}

}
