package GUI;

import UTILITIES.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class ConfirmToExit extends JDialog {
	
	Controller myController;

	public ConfirmToExit(Controller controller, JFrame currentPage){
		
		myController = controller;
		
		setTitle("Exit");
		setSize(350, 200);
		getContentPane().setLayout(null);
		setBackground(new Color(235, 235, 235));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		
		setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
		
		JLabel simpleText = new JLabel("Sei sicuro di voler uscire?");
		simpleText.setFont(new Font("Arial", Font.BOLD, 21));
		simpleText.setHorizontalAlignment(JLabel.CENTER);
		simpleText.setBounds(0, 12, 334, 50);
		getContentPane().add(simpleText);
		
		JLabel simpleText2 = new JLabel("Tornerai alla pagina di Login");
		simpleText2.setFont(new Font("Arial", Font.BOLD, 20));
		simpleText2.setHorizontalAlignment(JLabel.CENTER);
		simpleText2.setBounds(0, 47, 334, 50);
		getContentPane().add(simpleText2);
		
		setVisible(true);
		
		JButton esciButton = new JButton("Esci");
		esciButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		esciButton.setForeground(Color.WHITE);
		esciButton.setBackground(new Color(10, 100, 255));
		esciButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		esciButton.setBounds(65, 110, 65, 30);
		esciButton.setFocusable(false);
		getContentPane().add(esciButton);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		annullaButton.setForeground(Color.WHITE);
		annullaButton.setBackground(new Color(10, 100, 255));
		annullaButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		annullaButton.setBounds(200, 110, 65, 30);
		annullaButton.setFocusable(false);
		getContentPane().add(annullaButton);
		
		esciButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.GotoLoginPage(currentPage);
				dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(10, 100, 255));
			}
		});
		
		annullaButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(10, 100, 255));
			}
		});
	}
}
