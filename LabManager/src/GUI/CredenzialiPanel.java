package GUI;

import javax.swing.JPanel;

import UTILITIES.Controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CredenzialiPanel extends JPanel {

	Controller myController;
	PasswordComponent passwordComponent;
	JLabel showMatricola;
	
	public JLabel passwordBreve;

	public CredenzialiPanel(Controller controller) {

		myController = controller;

		setLayout(null);

		RegisterButton registerButton = new RegisterButton(myController, this);
		registerButton.setBounds(110, 620, 390, 50);
		add(registerButton);
		
		passwordBreve = new JLabel("Lunghezza della password non consentita!");
		passwordBreve.setBounds(45, 575, 515, 22);
		passwordBreve.setForeground(Color.RED);
		passwordBreve.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		passwordBreve.setHorizontalAlignment(JLabel.CENTER);
		passwordBreve.setVisible(false);
		add(passwordBreve);

		JLabel benvenuto = new JLabel("Benvenuto!");
		benvenuto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		benvenuto.setHorizontalAlignment(JLabel.CENTER);
		benvenuto.setBounds(0, 65, 640, 50);
		add(benvenuto);

		JLabel messaggioMatricolaAssegnata = new JLabel("La tua Matricola è:");
		messaggioMatricolaAssegnata.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		messaggioMatricolaAssegnata.setHorizontalAlignment(JLabel.CENTER);
		messaggioMatricolaAssegnata.setBounds(0, 111, 640, 50);
		add(messaggioMatricolaAssegnata);

		showMatricola = new JLabel();
		showMatricola.setFont(new Font("Arial", Font.BOLD, 60));
		showMatricola.setHorizontalAlignment(JLabel.CENTER);
		showMatricola.setBounds(0, 190, 640, 70);
		add(showMatricola);
		
		JLabel passwordHint1 = new JLabel("- Assicurati che la tua password sia sicura");
		passwordHint1.setFont(new Font("Arial", Font.ITALIC, 20));
		passwordHint1.setHorizontalAlignment(JLabel.LEFT);
		passwordHint1.setBounds(110, 405, 640, 70);
		passwordHint1.setForeground(new Color(90, 90, 90));
		add(passwordHint1);
		
		JLabel passwordHint2 = new JLabel("- La password deve avere lunghezza");
		passwordHint2.setFont(new Font("Arial", Font.ITALIC, 20));
		passwordHint2.setHorizontalAlignment(JLabel.LEFT);
		passwordHint2.setBounds(110, 440, 640, 70);
		passwordHint2.setForeground(new Color(90, 90, 90));
		add(passwordHint2);
		
		JLabel passwordHint2More = new JLabel("compresa tra 8 e 16 caratteri");
		passwordHint2More.setFont(new Font("Arial", Font.ITALIC, 20));
		passwordHint2More.setHorizontalAlignment(JLabel.LEFT);
		passwordHint2More.setBounds(123, 465, 640, 70);
		passwordHint2More.setForeground(new Color(90, 90, 90));
		add(passwordHint2More);
		
		passwordComponent = new PasswordComponent("Crea una Password");
		passwordComponent.setBounds(0, 15, 640, 720);
		add(passwordComponent);

	}
	
	public String getPasswordInserted() {
		
		return passwordComponent.getPassword();
	}
	
	public void setMatricolaToShow(String matricolaGenerated) {
		
		showMatricola.setText(matricolaGenerated);
	}
	

}
