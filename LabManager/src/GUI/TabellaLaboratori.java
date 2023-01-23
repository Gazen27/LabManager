package GUI;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UTILITIES.Controller;

public class TabellaLaboratori extends JTable {
	
	private Vector<Vector<String>> Dati;
	private Vector<String> Colonne;
	private DefaultTableModel tableModel;
	
	Controller myController;
	
	public TabellaLaboratori(Controller controller) {
		setShowVerticalLines(false);
		setEnabled(false);
		setRowSelectionAllowed(false);
		
		myController = controller;
		
		setBackground(new Color(235, 235, 235));
		setSize(500, 500);
		
		Colonne = new Vector<String>();
		Colonne.add("Codice");
		Colonne.add("Laboratorio");
		Colonne.add("Sede");
		Colonne.add("Tecnici");
		Colonne.add("Iscritto");
		
		this.Dati = myController.infoLaboratorio();
		
		tableModel = new DefaultTableModel(Dati, Colonne);
		
		this.setModel(tableModel);
	}

}
