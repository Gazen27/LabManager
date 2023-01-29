package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class RiepilogoStrumento extends JDialog {

	Controller myController;
	
	public RiepilogoStrumento(Controller controller) {
		
		myController = controller;
		
		Color sfondo = new Color(235, 235, 235);
		
		setSize(700, 550);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBackground(sfondo);
		setVisible(false);
		
		JLabel line1 = new JLabel("      ________________________________________________________________________________");
		line1.setFont(new Font("Arial", Font.BOLD, 15));
		line1.setBounds(0, 45, 684, 20);
		getContentPane().add(line1);
	}
}
