package GUI;

import UTILITIES.Controller;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class LaboratoriPage extends JPanel{

	Controller myController;
	
	public LaboratoriPage(Controller controller) {
		
		myController = controller;
		
		setLayout(null);
		
		setBackground(new Color(235, 235, 235));
		setSize(930, 720);
		
		JLabel pageTitle = new JLabel("I NOSTRI LABORATORI");
		pageTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		pageTitle.setBounds(30, 25, 900, 50);
		pageTitle.setHorizontalAlignment(JLabel.LEFT);
		add(pageTitle);
		
		ComponentTabella tabellaLab = new ComponentTabella(myController);
		tabellaLab.setBounds(30, 105, 800, 402);
		add(tabellaLab);
		
		JLabel info = new JLabel("Clicca su uno dei laboratori per aprirne la pagina e procedere con l'iscrizione");
		info.setFont(new Font("Arial", Font.ITALIC, 20));
		info.setBounds(30, 526, 870, 30);
		add(info);
		
		this.setVisible(false);
	}
}
