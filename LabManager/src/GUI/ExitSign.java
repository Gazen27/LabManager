package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ExitSign extends JLabel {
	
	public ExitSign() {

		setText("X");
		setFont(new Font("Arial", Font.BOLD, 25));
		setHorizontalTextPosition(JLabel.CENTER);
		setForeground(new Color(10, 100, 255));
		
		//Event to close the window
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
			public void mouseEntered(MouseEvent e) {
				setForeground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				setForeground(new Color(10, 100, 255));
			}
		});
	}
}
