package GUI;

import UTILITIES.Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class ReturnToLoginPage extends JDialog {
	
	Controller myController;
	
	public ReturnToLoginPage(Controller controller, String text, JFrame window) {
		
		myController = controller;
		
		setTitle("Fine");
		setSize(350, 200);
		getContentPane().setLayout(null);
		setBackground(new Color(235, 235, 235));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		
		JLabel simpleText = new JLabel(text);
		simpleText.setFont(new Font("Arial", Font.BOLD, 21));
		simpleText.setHorizontalAlignment(JLabel.CENTER);
		simpleText.setBounds(0, 12, 334, 50);
		getContentPane().add(simpleText);
		
		JLabel simpleText2 = new JLabel("Verrai reindirizzato al Login");
		simpleText2.setFont(new Font("Arial", Font.BOLD, 20));
		simpleText2.setHorizontalAlignment(JLabel.CENTER);
		simpleText2.setBounds(0, 47, 334, 50);
		getContentPane().add(simpleText2);
		
		setVisible(true);
		
		JButton okayButton = new JButton("OK!");
		okayButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		okayButton.setForeground(Color.WHITE);
		okayButton.setBackground(new Color(10, 100, 255));
		okayButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		okayButton.setBounds(140, 107, 50, 30);
		okayButton.setFocusable(false);
		getContentPane().add(okayButton);
		
		
		okayButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.ReturnAfterRegistration(window);
			}
			
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(10, 100, 255));
			}
		});
	}

}
