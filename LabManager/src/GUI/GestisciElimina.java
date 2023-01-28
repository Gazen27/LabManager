package GUI;

import UTILITIES.Controller;
import DTO.PrenotazionePersonale;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestisciElimina extends JDialog {
	
	Controller myController;
	
	public GestisciElimina(Controller controller, PrenotazionePersonale prenotazione) {
		
		myController = controller;
		
		Color sfondo = new Color(235, 235, 235);
		
		setSize(350, 225);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBackground(sfondo);
		setVisible(false);
		
		JLabel title = new JLabel("Prenotazione numero: 00" + prenotazione.getCodicePrenotazione());
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBounds(0, 15, 334, 25);
		getContentPane().add(title);
		
		JButton gestisci = new JButton("Gestisci prenotazione");
		gestisci.setFont(new Font("Segoe UI", Font.BOLD, 20));
		gestisci.setBackground(new Color(10, 100, 255));
		gestisci.setForeground(Color.WHITE);
		gestisci.setBounds(40, 60, 255, 40);
		gestisci.setFocusable(false);
		add(gestisci);
		
		JButton elimina = new JButton("Elimina prenotazione");
		elimina.setFont(new Font("Segoe UI", Font.BOLD, 20));
		elimina.setBackground(new Color(255, 70, 70));
		elimina.setForeground(Color.WHITE);
		elimina.setBounds(40, 120, 255, 40);
		elimina.setFocusable(false);
		add(elimina);
		
		
		gestisci.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.openGestionePrenotazioni(prenotazione);
			}
			
			public void mouseEntered(MouseEvent e) {
				gestisci.setFont(new Font("Segoe UI", Font.BOLD, 18));
				gestisci.setBackground(new Color(0, 75, 210));
			}
			
			public void mouseExited(MouseEvent e) {
				gestisci.setFont(new Font("Segoe UI", Font.BOLD, 20));
				gestisci.setBackground(new Color(10, 100, 255));
			}
		});
		
		
		
		elimina.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.requestConfirm(prenotazione);
			}
			
			public void mouseEntered(MouseEvent e) {
				elimina.setBackground(new Color(200, 30, 30));
				elimina.setFont(new Font("Segoe UI", Font.BOLD, 18));
			}
			
			public void mouseExited(MouseEvent e) {
				elimina.setBackground(new Color(255, 70, 70));
				elimina.setFont(new Font("Segoe UI", Font.BOLD, 20));
			}
		});
		
	}
}
