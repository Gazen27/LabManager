package GUI;

import javax.swing.*;

import UTILITIES.Controller;

import java.awt.*;

public class RegisterWindow extends JFrame {
	
	Controller myController;
		
	//Constructor
	public RegisterWindow(Controller controller) {
		
		myController = controller;
		
		setSize(1280, 720);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new GridLayout(0, 2));
		
		//Creating the sides of the Window
		LeftSidePanel leftPanel = new LeftSidePanel();
		add(leftPanel);
				
		RegisterPanel registerPanel = new RegisterPanel(myController, this);
		add(registerPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
}