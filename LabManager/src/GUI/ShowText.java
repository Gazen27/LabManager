package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ShowText extends JLabel {
	
	public ShowText(JPasswordField passText, String message) {
		
		JLabel occhio = new JLabel(new ImageIcon(getClass().getResource("/MediaFiles/OcchioPassword.png")));
		occhio.setLocation(0, 0);
		occhio.setSize(27, 23);
		add(occhio);

		addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				passText.setEchoChar((char) 0);
			}
			public void mouseExited(MouseEvent e) {
				passText.setEchoChar('•');
			}
		});
	}
}