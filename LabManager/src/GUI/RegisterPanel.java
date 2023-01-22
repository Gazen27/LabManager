package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UTILITIES.Controller;

public class RegisterPanel extends JPanel {
	
	Controller myController;
	
	public RegisterPanel(Controller controller, JFrame thisFrame) {
		
		myController = controller;
		
		setBackground(new Color(235, 235, 235));
		setLayout(null);
		
		ExitSign exit = new ExitSign();
		exit.setBounds(610, 10, 25, 25);
		add(exit);
		
		CredenzialiPanel credenziali = new CredenzialiPanel(myController);
		credenziali.setBounds(0, 0, 640, 720);
		credenziali.setVisible(false);
		add(credenziali);
		
		AnagraficaPanel anagrafica = new AnagraficaPanel(myController, thisFrame, credenziali);
		anagrafica.setBounds(0, -10, 640, 720);
		anagrafica.setVisible(true);
		
		add(anagrafica);
	}
}