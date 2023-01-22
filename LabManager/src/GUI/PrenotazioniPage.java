package GUI;

import UTILITIES.Controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PrenotazioniPage extends JPanel {
	
	Controller myController;
	
	public PrenotazioniPage(Controller controller) {
		
		myController = controller;
		
		setLayout(null);
		
		setBackground(new Color(235, 235, 235));
		setSize(930, 720);
		
		JLabel pageTitle = new JLabel("LE TUE PRENOTAZIONI");
		pageTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		pageTitle.setBounds(30, 25, 900, 50);
		pageTitle.setHorizontalAlignment(JLabel.LEFT);
		add(pageTitle);
		
		this.setVisible(false);
	}

}
