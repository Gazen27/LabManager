package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import UTILITIES.Controller;

public class BackArrow extends JLabel{
	
	Controller myController;
	
	public BackArrow(Controller controller, JFrame currentPage) {
		
		setText("<");
		setFont(new Font("Arial", Font.BOLD, 35));
		setHorizontalTextPosition(JLabel.CENTER);
		setForeground(new Color (30, 30, 30));
		
		Color arrowColor = this.getForeground();
		
		//Event to go to the previous frame
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						
				controller.GotoLoginPage(currentPage);
			}
			
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(10, 100, 255));
			}
			public void mouseExited(MouseEvent e) {
				setForeground(arrowColor);
			}
		});
	}
}
