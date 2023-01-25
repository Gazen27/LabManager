package GUI;

import UTILITIES.Controller;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LaboratoriPage extends JPanel{

	Controller myController;

	public LaboratoriPage(Controller controller) {
		
		myController = controller;
		
		setLayout(null);
		
		this.setVisible(false);
		setBackground(new Color(235, 235, 235));
		setSize(930, 720);
		
		JLabel pageTitle = new JLabel("I NOSTRI LABORATORI");
		pageTitle.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		pageTitle.setBounds(30, 25, 900, 50);
		pageTitle.setHorizontalAlignment(JLabel.LEFT);
		add(pageTitle);
		
		ComponentTabella tabellaLab = new ComponentTabella(myController);
		tabellaLab.setBounds(30, 105, 800, 402);
		add(tabellaLab);
		
		JLabel info = new JLabel("Clicca su uno dei laboratori per aprirne la pagina e procedere con l'iscrizione");
		info.setFont(new Font("Arial", Font.ITALIC, 20));
		info.setBounds(30, 520, 870, 30);
		add(info);
		
		
		JButton nuovaPostazione = new JButton("Aggiungi postazione");
		nuovaPostazione.setBackground(new Color(10, 100, 255));
		nuovaPostazione.setForeground(Color.WHITE);
		nuovaPostazione.setFont(new Font("Segoe UI", Font.BOLD, 20));
		nuovaPostazione.setBounds(60, 575, 750, 50);
		nuovaPostazione.setFocusable(false);
		nuovaPostazione.setEnabled(false);
		add(nuovaPostazione);
		
		if(!nuovaPostazione.isEnabled()) {
			
			nuovaPostazione.setOpaque(false);
			
		} else if(nuovaPostazione.isEnabled()) {
			
			nuovaPostazione.setOpaque(true);
			nuovaPostazione.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		}
		
		if(!myController.alreadyResponsabile()) {
		
			nuovaPostazione.setEnabled(false);;
			nuovaPostazione.setOpaque(false);
			
		} else { 
			
			nuovaPostazione.setEnabled(true);;
			nuovaPostazione.setOpaque(true);
		}



		nuovaPostazione.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				
			}
			
			public void mouseEntered(MouseEvent e) {
				nuovaPostazione.setBackground(new Color(0, 75, 210));
				nuovaPostazione.setFont(new Font("Segoe UI", Font.BOLD, 18));
			}
			
			public void mouseExited(MouseEvent e) {
				nuovaPostazione.setBackground(new Color(10, 100, 255));
				nuovaPostazione.setFont(new Font("Segoe UI", Font.BOLD, 20));
			}
		});
		

	}
}
