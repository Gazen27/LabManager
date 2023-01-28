package GUI;

import UTILITIES.Controller;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
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
		
		ComponentTabellaStrumenti tabellaStr = new ComponentTabellaStrumenti(myController);
		tabellaStr.setBounds(30, 105, 800, 402);
		add(tabellaStr);
		
		
		JLabel info = new JLabel("Clicca su uno strumento per aprire la sua pagina di riepilogo");
		info.setHorizontalAlignment(JLabel.LEFT);
		info.setFont(new Font("Arial", Font.ITALIC, 20));
		info.setBounds(30, 520, 870, 30);
		add(info);
		
		PrenotaButton prenotaStrumentoButton = new PrenotaButton(myController);
		prenotaStrumentoButton.setBounds(155, 585, 550, 50);
		add(prenotaStrumentoButton);
		
	}
}
