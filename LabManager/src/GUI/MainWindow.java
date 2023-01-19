package GUI;

import UTILITIES.Controller;
import UTILITIES.Session;

import java.awt.Color;

import javax.swing.JFrame;

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

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(false);
		
		ExitButton exit = new ExitButton(myController, this);
		exit.setBounds(150, 635, 50, 25);
		
		add(exit);
		add(leftMenu);

	}

}
