package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JLabel;

import DTO.Strumento;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class EffettuaPrenotazione extends JDialog {
	
	Controller myController;
	
	public EffettuaPrenotazione(Controller controller, Strumento strumento) {
		
		myController = controller;
		
		setSize(500, 450);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel strumentoDaPrenotare = new JLabel();
		strumentoDaPrenotare.setFont(new Font("Arial", Font.BOLD, 20));
		strumentoDaPrenotare.setHorizontalAlignment(JLabel.LEFT);
		strumentoDaPrenotare.setBounds(10, 11, 350, 30);
		getContentPane().add(strumentoDaPrenotare);
		
		
	}

}
