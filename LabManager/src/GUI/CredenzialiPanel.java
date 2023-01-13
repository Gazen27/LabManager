package GUI;

import javax.swing.JPanel;

import UTILITIES.Controller;

import java.awt.Font;

import javax.swing.JLabel;

public class CredenzialiPanel extends JPanel {

	Controller myController;
	PasswordComponent passwordComponent;
	JLabel showMatricola;

	public CredenzialiPanel(Controller controller) {

		myController = controller;

		setLayout(null);

		RegisterButton registerButton = new RegisterButton(myController, this);
		registerButton.setBounds(110, 620, 390, 50);
		add(registerButton);

		JLabel benvenuto = new JLabel("Benvenuto!");
		benvenuto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		benvenuto.setHorizontalAlignment(JLabel.CENTER);
		benvenuto.setBounds(0, 60, 640, 50);
		add(benvenuto);

		JLabel messaggioMatricolaAssegnata = new JLabel("La tua Matricola è:");
		messaggioMatricolaAssegnata.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		messaggioMatricolaAssegnata.setHorizontalAlignment(JLabel.CENTER);
		messaggioMatricolaAssegnata.setBounds(0, 105, 640, 50);
		add(messaggioMatricolaAssegnata);

		showMatricola = new JLabel();
		showMatricola.setFont(new Font("Arial", Font.BOLD, 60));
		showMatricola.setHorizontalAlignment(JLabel.CENTER);
		showMatricola.setBounds(0, 200, 640, 70);
		add(showMatricola);

		passwordComponent = new PasswordComponent("Crea una Password");
		passwordComponent.setBounds(0, 145, 640, 720);
		add(passwordComponent);

	}
	
	public String getPasswordInserted() {
		
		return passwordComponent.getPassword();
	}
	
	public void setMatricolaToShow(String matricolaGenerated) {
		
		showMatricola.setText(matricolaGenerated);
	}
	

}
