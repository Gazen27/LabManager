package GUI;

import UTILITIES.Controller;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JFrame;

public class ExitButton extends JLabel {

	Controller myController;
		
	public ExitButton(Controller controller, JFrame currentFrame) {
		
		myController = controller;
		
		setText("ESCI");
		setHorizontalAlignment(JLabel.CENTER);
		setFont(new Font("Arial", Font.BOLD, 21));
		setForeground(Color.WHITE);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						
				controller.GotoLoginPage(currentFrame);
			}
			
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(220, 220, 220));
				setFont(new Font("Arial", Font.BOLD, 19));
			}
			public void mouseExited(MouseEvent e) {
				setForeground(Color.WHITE);
				setFont(new Font("Arial", Font.BOLD, 21));
			}
		});
	}
}
