package GUI;

import UTILITIES.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;

public class GoToProfiloPage extends JButton {

	Controller myController;
	
	public GoToProfiloPage(Controller controller) {
		
		myController = controller;
		
		setText("Profilo");
		setBackground(new Color(10, 100, 255));
		setFont(new Font("Arial", Font.BOLD, 25));
		setForeground(Color.WHITE);
		
		setBorder(new MatteBorder(2, 0, 2, 0, Color.WHITE));
		setFocusable(false);
		
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				

			}
			
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 75, 210));
				setFont(new Font("Arial", Font.BOLD, 23));
			}
			
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(10, 100, 255));
				setFont(new Font("Arial", Font.BOLD, 25));
			}
		});
	}
}
