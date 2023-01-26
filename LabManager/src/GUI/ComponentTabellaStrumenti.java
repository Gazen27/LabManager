package GUI;

import UTILITIES.Controller;

import java.awt.Color;

import javax.swing.JScrollPane;

import javax.swing.ScrollPaneLayout;


public class ComponentTabellaStrumenti extends JScrollPane{

	private TabellaStrumenti tabellaStrumenti;
	
	Controller myController;
	
	public ComponentTabellaStrumenti(Controller controller) {
		
		myController = controller;
		
		setBorder(null);
		
		setBackground(new Color(235, 235, 235));
		setLayout(new ScrollPaneLayout());

		tabellaStrumenti = new TabellaStrumenti(myController);
		
		setViewportView(tabellaStrumenti);
	}
	
}
