package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import UTILITIES.Controller;

public class GoToRegisterLabel extends JLabel {
	
	public Controller myController;

	public GoToRegisterLabel(Controller controller, JFrame loginPage) {
		
		myController = controller;
		
		setText("Registrati");
		setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		setHorizontalAlignment(JLabel.LEFT);
		setBackground(new Color(10, 100, 255));
		
		Color registerColor = this.getForeground();
		
		//Event to create register window
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				myController.GotoRegisterPage(loginPage);
			}
			
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(10, 100, 255));
			}
			public void mouseExited(MouseEvent e) {
				setForeground(registerColor);
			}
		});
		
	}

}
