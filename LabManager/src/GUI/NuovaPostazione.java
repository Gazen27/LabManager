package GUI;

import UTILITIES.Controller;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuovaPostazione extends JDialog {

	Controller myController;
	
	JComboBox maxStrumenti;
	
	public NuovaPostazione(Controller controller, String nomeLab, Integer codSede) {
		
		myController = controller;
		
		setTitle("Nuova Postazione");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setSize(500, 300);
		
		setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
		
		setBackground(new Color(235, 235, 235));
		
		JLabel topLine = new JLabel("_________________________________________________________");
		topLine.setFont(new Font("Arial", Font.BOLD, 15));
		topLine.setHorizontalAlignment(JLabel.CENTER);
		topLine.setBounds(0, 0, 484, 24);
		getContentPane().add(topLine);
		
		
		JLabel bottomLine = new JLabel("_________________________________________________________");
		bottomLine.setFont(new Font("Arial", Font.BOLD, 15));
		bottomLine.setHorizontalAlignment(JLabel.CENTER);
		bottomLine.setBounds(0, 65, 484, 24);
		getContentPane().add(bottomLine);
		
		JLabel sede = new JLabel("Responsabile di: " + nomeLab + " - 00" + codSede);
		sede.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		sede.setHorizontalAlignment(JLabel.CENTER);
		sede.setBounds(0, 30, 484, 44);
		getContentPane().add(sede);
		
		JLabel nuovo = new JLabel("Crea nuova postazione");
		nuovo.setFont(new Font("Arial", Font.BOLD, 23));
		nuovo.setHorizontalAlignment(JLabel.LEFT);
		nuovo.setBounds(10, 100, 275, 35);
		getContentPane().add(nuovo);
		
		JLabel numeroStrumentiMax = new JLabel("• Numero massimo di strumenti:");
		numeroStrumentiMax.setFont(new Font("Arial", Font.BOLD, 23));
		numeroStrumentiMax.setHorizontalAlignment(JLabel.LEFT);
		numeroStrumentiMax.setBounds(10, 140, 360, 35);
		getContentPane().add(numeroStrumentiMax);
		
		
		Integer[] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		maxStrumenti = new JComboBox(lista);
		maxStrumenti.setFont(new Font("Arial", Font.BOLD, 19));
		maxStrumenti.setBounds(380, 146, 75, 25);
		getContentPane().add(maxStrumenti);
		
		
		JButton confermaButton = new JButton("Conferma");
		confermaButton.setBackground(new Color(10, 100, 255));
		confermaButton.setForeground(Color.WHITE);
		confermaButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
		confermaButton.setBounds(85, 200, 300, 40);
		getContentPane().add(confermaButton);
		
		confermaButton.setFocusable(false);
		
		confermaButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.createNewPostazione(nomeLab, codSede, getMaxStrumenti());
			}
			
			public void mouseEntered(MouseEvent e) {
				confermaButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
				confermaButton.setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				confermaButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
				confermaButton.setBackground(new Color(10, 100, 255));
			}
		});
	}
	
	
	public Integer getMaxStrumenti(){
		
		return (Integer)maxStrumenti.getSelectedItem();
	}
}
