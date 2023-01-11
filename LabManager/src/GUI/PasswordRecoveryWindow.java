package GUI;

import java.awt.GridLayout;

import javax.swing.JFrame;

import UTILITIES.Controller;

public class PasswordRecoveryWindow extends JFrame {
	
	Controller myController;
	
	public PasswordRecoveryWindow(Controller controller) {
		
		myController = controller;
		
		setSize(1280, 720);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new GridLayout(0, 2));
		
		//Creating the sides of the Window
		LeftSidePanel leftPanel = new LeftSidePanel();
		add(leftPanel);
		
		PasswordRecoveryPanel rightPanel = new PasswordRecoveryPanel(myController, this);
		add(rightPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
}
