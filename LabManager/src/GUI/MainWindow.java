package GUI;


import UTILITIES.Controller;

import UTILITIES.Session;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
	
	Controller myController;
	JPanel[] allPanels;
	
	private LeftMenu leftMenu;
	
	public MainWindow(Controller controller, Session currentSession) {
		
		myController = controller;
		
		getContentPane().setLayout(null);
		
		setTitle("Lab Manager");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setBackground(new Color(235, 235, 235));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(false);
		
		ExitButton exit = new ExitButton(myController, this);
		exit.setBounds(150, 635, 50, 25);
		
		JLabel atomLogo = new JLabel(new ImageIcon(getClass().getResource("/MediaFiles/Atom.png")));
		atomLogo.setLocation(677, 139);
		atomLogo.setSize(265, 285);
		
		JLabel benvenuto = new JLabel("BENVENUTO!");
		benvenuto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		benvenuto.setForeground(new Color(20, 20, 20));
		benvenuto.setHorizontalAlignment(JLabel.CENTER);
		benvenuto.setBounds(350, 435, 930, 60);
		
		allPanels = new JPanel[3];
		
		leftMenu = new LeftMenu(myController, currentSession, allPanels);
		leftMenu.setLocation(0, 0);
		
		CurrentDate currentDate = new CurrentDate();
		currentDate.setBounds(1125, 650, 130, 25);
		getContentPane().add(currentDate);
		
///////////////////////// PANELS /////////////////////////
		
		LaboratoriPage laboratori = new LaboratoriPage(myController);
		laboratori.setLocation(350, 0);
		allPanels[0] = laboratori;
		
		StrumentiPage strumentiPage = new StrumentiPage(myController);
		strumentiPage.setLocation(350, 0);
		allPanels[1] = strumentiPage;
		
		
		
		PrenotazioniPage prenotazioni = new PrenotazioniPage(myController);
		prenotazioni.setLocation(350, 0);
		allPanels[2] = prenotazioni;
		
		
		getContentPane().add(exit);
		getContentPane().add(leftMenu);
		getContentPane().add(laboratori);
		getContentPane().add(strumentiPage);
		getContentPane().add(prenotazioni);
		
		
		getContentPane().add(atomLogo);
		getContentPane().add(benvenuto);
	}

}
