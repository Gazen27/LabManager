package GUI;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class PasswordComponent extends JComponent {
	
	JPasswordField passwordField;

	public PasswordComponent(String textToShow) {
		
		setLayout(null);
		
		JLabel passwordLabel = new JLabel(textToShow);
		passwordLabel.setBounds(110, 330, 230, 25);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 23));
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 360, 390, 35);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		
		ShowText showPassword = new ShowText(passwordField, "Mostra Password");
		showPassword.setBounds(505, 366, 27, 23);
		
		add(showPassword);
		add(passwordLabel);
		add(passwordField);
		
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
	
}
