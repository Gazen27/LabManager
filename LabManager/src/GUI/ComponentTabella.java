package GUI;

import UTILITIES.Controller;

import java.awt.Color;

import javax.swing.JScrollPane;

import javax.swing.ScrollPaneLayout;


public class ComponentTabella extends JScrollPane{

	private TabellaLaboratori tabella;
	
	Controller myController;
	
	public ComponentTabella(Controller controller) {
		
		myController = controller;
		
		setBorder(null);
		
		setBackground(new Color(235, 235, 235));
		setLayout(new ScrollPaneLayout());

		tabella = new TabellaLaboratori(myController);
		
		setViewportView(tabella);
	}
	
}


