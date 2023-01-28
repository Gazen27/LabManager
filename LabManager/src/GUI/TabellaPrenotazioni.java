package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UTILITIES.CenterRenderer;
import UTILITIES.Controller;
import java.awt.event.MouseEvent;

public class TabellaPrenotazioni extends JTable {
	
	private Vector<Vector<String>> Dati;
	private Vector<String> Colonne;
	private DefaultTableModel tableModel;
	
	Controller myController;
	
	public TabellaPrenotazioni(Controller controller) {
		
		myController = controller;
		
		setBorder(null);

		setShowVerticalLines(false);
		
		setBackground(new Color(235, 235, 235));
		setSize(500, 500);
		
		this.setDefaultRenderer(Object.class, new CenterRenderer());
		
		Colonne = new Vector<String>();
		Colonne.add("Codice"); //0
		Colonne.add("Strumento"); //1
		Colonne.add("Laboratorio"); //2
		Colonne.add("Postazione"); //3
		Colonne.add("Data"); //4
		Colonne.add("Tempo(ore)"); //5
		
		this.Dati = myController.infoPrenotazione();
		
		tableModel = new DefaultTableModel(Dati, Colonne);
		
		this.setModel(tableModel);
		
		this.getTableHeader().setBackground(new Color(15, 120, 255));
		
		this.getTableHeader().setPreferredSize(
			     new Dimension(170, 35)
			);
		
		this.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
		this.getTableHeader().setForeground(Color.WHITE);
		
		this.setRowHeight(26);
		
		this.setRowSelectionAllowed(true);	
		
		this.getColumnModel().getColumn(0).setCellRenderer(new CenterRenderer());
		
		this.getColumnModel().getColumn(0).setMinWidth(90);
		this.getColumnModel().getColumn(0).setMaxWidth(90);
		
		
		
		
        this.addMouseListener(new java.awt.event.MouseAdapter() {
        	
            public void mouseClicked(MouseEvent e) {
            	
        		int index = getSelectedRow();
        		
        		String codice = tableModel.getValueAt(index, 0).toString();
        		
        		myController.openGestisciElimina(codice);
            }
            
        });
		
	}

}