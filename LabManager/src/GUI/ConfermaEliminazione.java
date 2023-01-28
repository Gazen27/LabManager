package GUI;

import UTILITIES.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import DTO.PrenotazionePersonale;

public class ConfermaEliminazione extends JDialog {
	
	Controller myController;

	public ConfermaEliminazione(Controller controller, PrenotazionePersonale prenotazione) {
		
		myController = controller;
		
		Color mainColor = new Color(10, 100, 255);
		
		setSize(314, 160);
		setVisible(false);
		setResizable(false);
		setBackground(new Color(235, 235 , 235));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setTitle("Conferma");
		
		JLabel text1 = new JLabel("Sei sicuro di voler canellare");
		text1.setFont(new Font("Arial", Font.ITALIC, 20));
		text1.setHorizontalAlignment(JLabel.CENTER);
		text1.setBounds(0, 5, 298, 30);
		getContentPane().add(text1);
		
		JLabel text2 = new JLabel("la tua prenotazione?");
		text2.setFont(new Font("Arial", Font.ITALIC, 20));
		text2.setHorizontalAlignment(JLabel.CENTER);
		text2.setBounds(0, 35, 298, 30);
		getContentPane().add(text2);
		
		JButton conferma = new JButton("Conferma");
		conferma.setFont(new Font("Segoe UI", Font.BOLD, 15));
		conferma.setBackground(mainColor);
		conferma.setForeground(Color.WHITE);
		conferma.setBounds(30, 75, 105, 30);
		conferma.setFocusable(false);
		getContentPane().add(conferma);
		
		JButton annulla = new JButton("Annulla");
		annulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		annulla.setBackground(mainColor);
		annulla.setForeground(Color.WHITE);
		annulla.setBounds(165, 75, 105, 30);
		annulla.setFocusable(false);
		getContentPane().add(annulla);
		
		
		conferma.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.eliminaPrenotazione(prenotazione);
			}
			
			public void mouseEntered(MouseEvent e) {
				conferma.setFont(new Font("Segoe UI", Font.BOLD, 13));
				conferma.setBackground(new Color(0, 75, 210));
			}
			
			public void mouseExited(MouseEvent e) {
				conferma.setFont(new Font("Segoe UI", Font.BOLD, 15));
				conferma.setBackground(mainColor);
			}
		});
		
		
		annulla.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				annulla.setFont(new Font("Segoe UI", Font.BOLD, 13));
				annulla.setBackground(new Color(0, 75, 210));
			}
			
			public void mouseExited(MouseEvent e) {
				annulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
				annulla.setBackground(mainColor);
			}
		});
	}
}
