package GUI;

import UTILITIES.Controller;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import DTO.Sede;

import java.awt.Color;
import java.awt.Font;

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
		
		setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
		
		setBackground(new Color(235, 235, 235));
		
		JLabel message = new JLabel("Seleziona una sede");
		message.setFont(new Font("Arial", Font.BOLD, 20));
		message.setHorizontalAlignment(JLabel.LEFT);
		message.setBounds(10, 15, 250, 25);
		add(message);
		
		JComboBox listaSedi = new JComboBox(allSedi);
		listaSedi.setBounds(10, 55, 150, 30);
		add(listaSedi);
	}
}
