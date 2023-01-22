package GUI;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabellaLaboratori extends JScrollPane{
	
	private Vector<Vector<String>> dati;
	private Vector<Object> colonne;
	
	public TabellaLaboratori() {
		
		
		
		
		//Table
		colonne = new Vector<Object>();
		colonne.add("Codice");
		colonne.add("Laboratorio");
		colonne.add("Sede");
		colonne.add("Tecnici");
		colonne.add("Iscritto");
		colonne.add("altro");
		
		JTable tabella = new JTable();
	}
}
