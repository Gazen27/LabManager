package GUI;

import UTILITIES.Controller;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class GoToPrenotazioni extends JButton {
	
	Controller myController;

	public GoToPrenotazioni(Controller controller) {
		
		myController = controller;
		
		setText("Prenotazioni");
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