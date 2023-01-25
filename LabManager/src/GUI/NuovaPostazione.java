package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class NuovaPostazione extends JDialog {

	Controller myController;
	
	public NuovaPostazione(Controller controller) {
		
		myController = controller;
		
		setTitle("Postazione");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setLayout(null);
		setSize(500, 360);
		
		setBackground(new Color(235, 235, 235));
		
		JLabel title = new JLabel("Nuova Postazione");
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		title.setHorizontalAlignment(JLabel.LEFT);
		//title.setBounds(10, 10);
		add(title);
	}
}
