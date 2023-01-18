package GUI;

import UTILITIES.Controller;

import java.awt.Color;

import javax.swing.JFrame;

import DTO.Session;

public class MainWindow extends JFrame {
	
	Controller myController;
	
	private LeftMenu leftMenu;
	
	public MainWindow(Controller controller, Session currentSession) {
		
		myController = controller;
		
		setLayout(null);
		
		setTitle("Lab Manager");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setBackground(new Color(235, 235, 235));
		
		leftMenu = new LeftMenu(myController, currentSession);
		leftMenu.setLocation(0, 0);
		add(leftMenu);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(false);
	}

}
