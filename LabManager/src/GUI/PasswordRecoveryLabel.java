package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import UTILITIES.Controller;

public class PasswordRecoveryLabel extends JLabel {
	
	public Controller myController;
	
	public PasswordRecoveryLabel(Controller controller, JFrame loginPage) {
		
		myController = controller;
		
		setText("Password dimenticata");
		setFont(new Font("ARIAL", Font.ITALIC, 19));
		setHorizontalAlignment(JLabel.LEFT);
		setBackground(new Color(10, 100, 255));
		setForeground(new Color(90, 90, 90));
		
		Color PasswordRecoveryColor = this.getForeground();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				myController.GotoPasswordRecoveryPage(loginPage);
			}
			
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(232, 12, 12));
			}
			public void mouseExited(MouseEvent e) {
				setForeground(PasswordRecoveryColor);
			}
		});
		
	}
}
