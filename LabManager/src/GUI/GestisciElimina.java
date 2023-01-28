package GUI;

import UTILITIES.Controller;
import DTO.PrenotazionePersonale;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;

public class GestisciElimina extends JDialog {
	
	Controller myController;
	
	public GestisciElimina(Controller controller, PrenotazionePersonale prenotazione) {
		
		myController = controller;
		
		Color sfondo = new Color(235, 235, 235);
		
		setSize(300, 200);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setBackground(sfondo);
		
		JLabel title = new JLabel("Prenotazione numero: 00" + prenotazione.getCodicePrenotazione());
		
	}
}
