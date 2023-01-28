package GUI;

import UTILITIES.Controller;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrenotaButton extends JButton {

	Controller myController;
	
	public PrenotaButton(Controller controller) {
		
		myController = controller;;
		
		Color buttonColor = new Color(10, 100, 255);
		Color onButton = new Color(0, 75, 210);
		
		setText("Effettua prenotazione");
		setFont(new Font("Segoe UI", Font.BOLD, 25));
		setForeground(Color.WHITE);
		setBackground(buttonColor);
		setFocusable(false);
		
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.GotoSceltaSede();
			}
			
			public void mouseEntered(MouseEvent e) {
				setBackground(onButton);
				setFont(new Font("Segoe UI", Font.BOLD, 23));
			}
			
			public void mouseExited(MouseEvent e) {
				setBackground(buttonColor);
				setFont(new Font("Segoe UI", Font.BOLD, 25));
			}
		});
	}
}
