package GUI;

import UTILITIES.Controller;

import java.awt.Color;

import javax.swing.JScrollPane;

import javax.swing.ScrollPaneLayout;


public class ComponentTabellaPrenotazioni extends JScrollPane{

	private TabellaPrenotazioni tabella;
	
	Controller myController;
	
	public ComponentTabellaPrenotazioni(Controller controller) {
		
		myController = controller;
		
		setBorder(null);
		
		setBackground(new Color(235, 235, 235));
		setLayout(new ScrollPaneLayout());

		tabella = new TabellaPrenotazioni(myController);
		
		setViewportView(tabella);
	}
	
}