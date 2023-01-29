package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class CalendarioPrenotazione extends JDialog {
	
	Controller myController;
	
	public CalendarioPrenotazione(Controller controller, Integer codiceStrumento, String nomeStrumento) {
		
		myController = controller;
		
		setTitle("Calendario");
		getContentPane().setLayout(null);
		setSize(750, 550);
		setFocusable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		
		JLabel title = new JLabel("Prenotazioni per: " + "00" + codiceStrumento + " - " + nomeStrumento);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		title.setBounds(0, 16, 734, 35);
		getContentPane().add(title);
		
		JLabel line = new JLabel("______________________________________________________________________________________");
		line.setFont(new Font("Arial", Font.BOLD, 15));
		line.setHorizontalAlignment(JLabel.CENTER);
		line.setBounds(0, 50, 734, 20);
		getContentPane().add(line);
		
		ComponentTabellaCalendario tabCalendario = new ComponentTabellaCalendario(myController, codiceStrumento);
		tabCalendario.setBounds(22, 85, 690, 400);
		getContentPane().add(tabCalendario);
		
	}
}
