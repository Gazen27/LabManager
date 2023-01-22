package GUI;

import java.awt.*;
import javax.swing.*;

public class LeftSidePanel extends JPanel {

	public LeftSidePanel() {
		
		setBackground(new Color(10, 100, 255));
		setLayout(null);
		
		JLabel microscopio = new JLabel(new ImageIcon(getClass().getResource("/MediaFiles/MicroscopioCompleto.png")));
		microscopio.setLocation(20, -10);
		microscopio.setSize(1280, 720);
		
		JLabel logoText = new JLabel("LAB MANAGER");
        logoText.setBounds(0, 457, 640, 42);
        logoText.setForeground(Color.white);
        logoText.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 31));
        logoText.setHorizontalAlignment(JLabel.CENTER);
        
        add(logoText);
        add(microscopio);
	}
}