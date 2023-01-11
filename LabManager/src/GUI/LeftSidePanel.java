package GUI;

import java.awt.*;
import javax.swing.*;

public class LeftSidePanel extends JPanel {

	public LeftSidePanel() {
		
		setBackground(new Color(10, 100, 255));
		setLayout(null);
		
		JLabel microscopio = new JLabel(new ImageIcon(getClass().getResource("/MediaFiles/MicroscopioCompleto.png")));
		microscopio.setLocation(0, 0);
		microscopio.setSize(1280, 720);
		JLabel logoText = new JLabel("Lab Manager");
        logoText.setBounds(207, 467, 196, 42);
        logoText.setForeground(Color.white);
        logoText.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 30));
        
        add(logoText);
        add(microscopio);
	}
}