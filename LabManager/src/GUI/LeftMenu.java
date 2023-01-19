package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import UTILITIES.Controller;
import UTILITIES.Session;

public class LeftMenu extends JPanel {

		Controller myController;
		
	public LeftMenu(Controller controller, Session currentSession) {
		
		myController = controller;
		
		setBackground(new Color(10, 100, 255));
		setSize(350, 720);
		setVisible(true);
		setLayout(null);
		
		JLabel personLogo = new JLabel(new ImageIcon(getClass().getResource("/MediaFiles/ManShiluette.png")));
		personLogo.setLocation(95, 20);
		personLogo.setSize(160, 160);
		add(personLogo);
		
		JLabel nomeDisplayed = new JLabel(currentSession.getNomeCompleto());
		nomeDisplayed.setBounds(0, 195, 350, 30);
		nomeDisplayed.setFont(new Font("Arial", Font.BOLD, 27));
		nomeDisplayed.setForeground(new Color(235, 235, 235));
		nomeDisplayed.setHorizontalAlignment(JLabel.CENTER);
		add(nomeDisplayed);
		
	}
}
