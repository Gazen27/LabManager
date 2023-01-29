package GUI;

import UTILITIES.Controller;

import java.awt.Color;

import javax.swing.JScrollPane;

import javax.swing.ScrollPaneLayout;


public class ComponentTabellaCalendario extends JScrollPane{

	private TabellaCalendario tabella;
	
	Controller myController;
	
	public ComponentTabellaCalendario(Controller controller, Integer codiceStrumento) {
		
		myController = controller;
		
		setBorder(null);
		
		setBackground(new Color(235, 235, 235));
		setLayout(new ScrollPaneLayout());

		tabella = new TabellaCalendario(myController, codiceStrumento);
		
		setViewportView(tabella);
	}
	
}
