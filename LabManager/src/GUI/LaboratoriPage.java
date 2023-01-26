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
		
		
		JButton nuovaPostazioneButton = new JButton("Nuova postazione");
		nuovaPostazioneButton.setBackground(new Color(10, 100, 255));
		nuovaPostazioneButton.setForeground(Color.WHITE);
		nuovaPostazioneButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		nuovaPostazioneButton.setBounds(70, 575, 300, 50);
		nuovaPostazioneButton.setFocusable(false);
		nuovaPostazioneButton.setEnabled(false);
		add(nuovaPostazioneButton);
		
		if(!nuovaPostazioneButton.isEnabled()) {
			
			nuovaPostazioneButton.setOpaque(false);
			
		} else if(nuovaPostazioneButton.isEnabled()) {
			
			nuovaPostazioneButton.setOpaque(true);
			nuovaPostazioneButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		}
		
		
		JButton aggiungiStrumentoButton = new JButton("Aggiungi strumento");
		aggiungiStrumentoButton.setBackground(new Color(10, 100, 255));
		aggiungiStrumentoButton.setForeground(Color.WHITE);
		aggiungiStrumentoButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		aggiungiStrumentoButton.setBounds(490, 575, 300, 50);
		aggiungiStrumentoButton.setFocusable(false);
		aggiungiStrumentoButton.setEnabled(false);
		add(aggiungiStrumentoButton);

		if(!aggiungiStrumentoButton.isEnabled()) {
			
			aggiungiStrumentoButton.setOpaque(false);
			
		} else if(aggiungiStrumentoButton.isEnabled()) {
			
			aggiungiStrumentoButton.setOpaque(true);
			aggiungiStrumentoButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		}
		
		
		
		if(!myController.alreadyResponsabile()) {
			
			nuovaPostazioneButton.setEnabled(false);;
			nuovaPostazioneButton.setOpaque(false);
			
			
			aggiungiStrumentoButton.setEnabled(false);;
			aggiungiStrumentoButton.setOpaque(false);
			
		} else { 
			
			nuovaPostazioneButton.setEnabled(true);;
			nuovaPostazioneButton.setOpaque(true);
			
			
			aggiungiStrumentoButton.setEnabled(true);;
			aggiungiStrumentoButton.setOpaque(true);
		}
		
		
////////////////////////////////////// LISTENER //////////////////////////////////////
		
		if(nuovaPostazioneButton.isEnabled()) {
			
			nuovaPostazioneButton.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					
					myController.openNuovaPostazionePage();
				}
				
				public void mouseEntered(MouseEvent e) {
					nuovaPostazioneButton.setBackground(new Color(0, 75, 210));
					nuovaPostazioneButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
				}
				
				public void mouseExited(MouseEvent e) {
					nuovaPostazioneButton.setBackground(new Color(10, 100, 255));
					nuovaPostazioneButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
				}
			});

		}

		
		
		if(aggiungiStrumentoButton.isEnabled()) {
			
			aggiungiStrumentoButton.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					
					
				}
				
				public void mouseEntered(MouseEvent e) {
					aggiungiStrumentoButton.setBackground(new Color(0, 75, 210));
					aggiungiStrumentoButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
				}
				
				public void mouseExited(MouseEvent e) {
					aggiungiStrumentoButton.setBackground(new Color(10, 100, 255));
					aggiungiStrumentoButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
				}
			});

		}

	}
}
