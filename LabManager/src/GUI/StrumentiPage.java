package GUI;

import UTILITIES.Controller;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class StrumentiPage extends JPanel {
	
	Controller myController;
	
	public StrumentiPage(Controller controller) {
		
		myController = controller;
		
		setLayout(null);
		
		this.setVisible(false);
		setBackground(new Color(235, 235, 235));
		setSize(930, 720);
		
		JLabel pageTitle = new JLabel("STRUMENTI REGISTRATI");
		pageTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		pageTitle.setBounds(30, 25, 900, 50);
		pageTitle.setHorizontalAlignment(JLabel.LEFT);
		add(pageTitle);
		
		
	}
}
