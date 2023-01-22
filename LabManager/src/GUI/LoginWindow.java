package GUI;

import javax.swing.*;

import UTILITIES.Controller;

import java.awt.*;

public class LoginWindow extends JFrame {
	
	Controller myController;
		
	//Constructor
	public LoginWindow(Controller controller) {
		
		myController = controller;
		
		setSize(1280, 720);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new GridLayout(0, 2));
		
		//Creating the sides of the Window
		LeftSidePanel leftPanel = new LeftSidePanel();
		add(leftPanel);
				
		LoginPanel loginPanel = new LoginPanel(myController, this);
		add(loginPanel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
}