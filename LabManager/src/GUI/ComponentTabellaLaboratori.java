package GUI;

import UTILITIES.Controller;

import java.awt.Color;

import javax.swing.JScrollPane;

import javax.swing.ScrollPaneLayout;


public class ComponentTabellaLaboratori extends JScrollPane{

	private TabellaLaboratori tabella;
	
	Controller myController;
	
	public ComponentTabellaLaboratori(Controller controller) {
		
		myController = controller;
		
		setBorder(null);
		
		setBackground(new Color(235, 235, 235));
		setLayout(new ScrollPaneLayout());

		tabella = new TabellaLaboratori(myController);
		
		setViewportView(tabella);
	}
	
}


