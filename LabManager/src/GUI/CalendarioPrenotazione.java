package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class CalendarioPrenotazione extends JDialog {
	
	Controller myController;
	
	public CalendarioPrenotazione(Controller controller, String strumentoCompleto) {
		
		myController = controller;
		
		setTitle("Calendario");
		getContentPane().setLayout(null);
		setSize(750, 550);
		setFocusable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		
		JLabel title = new JLabel("Prenotazioni per: " + strumentoCompleto);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		title.setBounds(0, 15, 734, 35);
		getContentPane().add(title);
		
		
	}
}
