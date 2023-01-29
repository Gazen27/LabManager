package GUI;

import UTILITIES.Controller;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import DTO.Sede;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ScegliSede extends JDialog {

	Controller myController;
	
	private Vector<String> tutteSedi;
	
	public ScegliSede(Controller controller, Vector<String> allSedi) {
		
		myController = controller;
		
		setTitle("Sede");
		setSize(300, 150);
		setLayout(null);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBackground(new Color(235, 235, 235));
		
		JLabel message = new JLabel("Seleziona una sede");
		message.setFont(new Font("Arial", Font.BOLD, 20));
		message.setHorizontalAlignment(JLabel.LEFT);
		message.setBounds(10, 15, 250, 25);
		add(message);
		
		JComboBox listaSedi = new JComboBox(allSedi);
		listaSedi.setBounds(10, 55, 150, 30);
		add(listaSedi);
		
		JButton avantiButton = new JButton("Avanti");
		avantiButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		avantiButton.setBackground(new Color(10, 100, 255));
		avantiButton.setForeground(Color.WHITE);
		avantiButton.setBounds(180, 55, 85, 30);
		avantiButton.setFocusable(false);
		add(avantiButton);
		
		
		avantiButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				String sedeScelta = (String)listaSedi.getSelectedItem();
				
				myController.goToStrumentiDisponibili(sedeScelta);
			}
			
			public void mouseEntered(MouseEvent e) {
				avantiButton.setBackground(new Color(0, 75, 210));
				avantiButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
			}
			
			public void mouseExited(MouseEvent e) {
				avantiButton.setBackground(new Color(10, 100, 255));
				avantiButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
			}
		});
	}
}
