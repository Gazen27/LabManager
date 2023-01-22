package GUI;

import UTILITIES.Controller;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabellaLaboratori extends JScrollPane{
	
	private Vector<Vector<String>> dati;
	private Vector<Object> colonne;
	private DefaultTableModel tableModel;
	private JTable tabella;
	
	Controller myController;
	
	public TabellaLaboratori(Controller controller) {
		
		myController = controller;
		
		setBackground(new Color(235, 235, 235));
		
		//Table
		colonne = new Vector<Object>();
		colonne.add("Codice");
		colonne.add("Laboratorio");
		colonne.add("Sede");
		colonne.add("Tecnici");
		colonne.add("Iscritto");
		
		tableModel = new DefaultTableModel(dati, colonne);
		
		tabella = new JTable(tableModel);
		
		add(tabella);
	}
}
