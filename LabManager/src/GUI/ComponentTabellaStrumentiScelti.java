package GUI;

import UTILITIES.Controller;

import java.awt.Color;

import javax.swing.JScrollPane;

import javax.swing.ScrollPaneLayout;


public class ComponentTabellaStrumentiScelti extends JScrollPane{

	private TabellaStrumentiScelti tabellaStrumentiScelti;
	
	Controller myController;
	
	public ComponentTabellaStrumentiScelti(Controller controller, String sedeSelezionata) {
		
		myController = controller;
		
		setBorder(null);
		
		setBackground(new Color(235, 235, 235));
		setLayout(new ScrollPaneLayout());

		tabellaStrumentiScelti = new TabellaStrumentiScelti(myController, sedeSelezionata);
		
		setViewportView(tabellaStrumentiScelti);
	}
	
}