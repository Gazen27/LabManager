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

public class TabellaStrumentiScelti extends JTable {
	
	private Vector<Vector<String>> Info;
	private Vector<String> Colonne;
	private DefaultTableModel tableModel;
	
	Controller myController;
	
	public TabellaStrumentiScelti(Controller controller, String sedeSelezionata) {
		
		myController = controller;
		
		setBorder(null);

		setShowVerticalLines(false);
		
		setBackground(new Color(235, 235, 235));
		setSize(500, 500);
		
		Colonne = new Vector<String>();
		
		Colonne.add("Codice");
		Colonne.add("Strumento");
		Colonne.add("Descrizione");
		
		this.Info = myController.infoStrumentoScelto(sedeSelezionata);
		
		tableModel = new DefaultTableModel(Info, Colonne);
		
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
		
		this.getColumnModel().getColumn(1).setMinWidth(170);
		this.getColumnModel().getColumn(1).setMaxWidth(170);
		
		
		//VISUALIZZA LA PAGINA DELLO STRUMENTO SCELTO
        this.addMouseListener(new java.awt.event.MouseAdapter() {
        	
            public void mouseClicked(MouseEvent e) {
            	
        		int index = getSelectedRow();
        		
        		Integer codiceStrumento = Integer.parseInt((String)tableModel.getValueAt(index, 0));
        		
        		//TODO: APRI PRENOTAZIONE
            }
            
        });
	}

}