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
		
		ComponentTabellaPrenotazioni tabellaPren = new ComponentTabellaPrenotazioni(myController);
		tabellaPren.setBounds(30, 105, 800, 402);
		add(tabellaPren);
		
		JLabel info = new JLabel("Clicca su una prenotazione per aprirne la pagina di gestione");
		info.setHorizontalAlignment(JLabel.LEFT);
		info.setFont(new Font("Arial", Font.ITALIC, 20));
		info.setBounds(30, 518, 870, 30);
		add(info);
		
		PrenotaButton prenotaStrumentoButton = new PrenotaButton(myController);
		prenotaStrumentoButton.setBounds(155, 585, 550, 50);
		add(prenotaStrumentoButton);
		
		this.setVisible(false);
	}

}
