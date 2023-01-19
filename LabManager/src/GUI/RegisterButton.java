package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import UTILITIES.Controller;

public class RegisterButton extends JButton {
	
	Controller myController;
	
	public RegisterButton(Controller controller, CredenzialiPanel credenziali) {
		
		myController = controller;
		
		setText("Registrati");
		setFont(new Font("Segoe UI", Font.BOLD, 25));
		setForeground(Color.WHITE);
		setBackground(new Color(10, 100, 255));
		setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));	
		
		setFocusable(false);
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.EndRegistration(credenziali);
			}
			
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 75, 210));
				setFont(new Font("Segoe UI", Font.BOLD, 23));
			}
			
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(10, 100, 255));
				setFont(new Font("Segoe UI", Font.BOLD, 25));
			}
		});
	}
}
