package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class RegisterButton extends JButton {
	
	public RegisterButton() {
		
		setText("Registrati");
		setFont(new Font("Segoe UI", Font.BOLD, 25));
		setForeground(Color.WHITE);
		setBackground(new Color(10, 100, 255));
		setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));	
		
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(10, 100, 255));
			}
		});
	}
}
