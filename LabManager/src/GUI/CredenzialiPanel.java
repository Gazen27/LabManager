package GUI;

import javax.swing.JPanel;

import UTILITIES.Controller;

import java.awt.Font;

import javax.swing.JLabel;

public class CredenzialiPanel extends JPanel {

	Controller myController;

	public CredenzialiPanel(Controller controller) {

		myController = controller;

		setLayout(null);

		RegisterButton registerButton = new RegisterButton();
		registerButton.setBounds(110, 620, 390, 50);
		add(registerButton);

		JLabel benvenuto = new JLabel("Benvenuto!");
		benvenuto.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		benvenuto.setHorizontalAlignment(JLabel.CENTER);
		benvenuto.setBounds(0, 55, 640, 50);
		add(benvenuto);

		JLabel messaggioMatricolaAssegnata = new JLabel("La tua Matricola è:");
		messaggioMatricolaAssegnata.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		messaggioMatricolaAssegnata.setHorizontalAlignment(JLabel.CENTER);
		messaggioMatricolaAssegnata.setBounds(0, 100, 640, 50);
		add(messaggioMatricolaAssegnata);

		JLabel showMatricola = new JLabel("N86004180");
		showMatricola.setFont(new Font("Arial", Font.BOLD, 55));
		showMatricola.setHorizontalAlignment(JLabel.CENTER);
		showMatricola.setBounds(0, 195, 640, 60);
		add(showMatricola);

		PasswordComponent passwordComponent = new PasswordComponent("Crea una Password");
		passwordComponent.setBounds(0, 150, 640, 720);
		add(passwordComponent);

	}

}
