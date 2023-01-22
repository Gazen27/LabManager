package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import UTILITIES.Controller;

public class AvantiButton extends JButton{
	
	Controller myController;
	
	public AvantiButton(Controller controller, AnagraficaPanel currentAnagrafica, CredenzialiPanel currentCredenziali) {
		
		myController = controller;
		
		setText("Avanti");
		setFont(new Font("Segoe UI", Font.BOLD, 25));
		setForeground(Color.WHITE);
		setBackground(new Color(10, 100, 255));
		setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		
		setFocusable(false);
		
		//Event to create register window
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.GoAheadWithRegistration(currentAnagrafica, currentCredenziali);
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
