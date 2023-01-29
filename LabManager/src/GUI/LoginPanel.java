package GUI;

import java.awt.*;
import javax.swing.*;

import UTILITIES.Controller;

public class LoginPanel extends JPanel {
	
	private Controller myController;
	private MatricolaComponent matricolaComponent;
	private PasswordComponent passwordComponent;
	public DatiErratiMancanti datiErratiMancanti;
	

	public LoginPanel(Controller controller, JFrame thisFrame) {
		
		myController = controller;
		
		setBackground(new Color(235, 235, 235));
		setLayout(null);
		
		ExitSign exit = new ExitSign();
		exit.setBounds(610, 10, 25, 25);
		add(exit);
		
		LoginButton loginButton = new LoginButton(myController, this);
		loginButton.setBounds(110, 525, 390, 50);
		add(loginButton);
		
		datiErratiMancanti = new DatiErratiMancanti();
		datiErratiMancanti.setBounds(40, 480, 515, 22);
		add(datiErratiMancanti);
		datiErratiMancanti.setVisible(false);
		
		JLabel scrittaAccedi = new JLabel("Accedi");
		scrittaAccedi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 55));
		scrittaAccedi.setHorizontalAlignment(JLabel.CENTER);
		scrittaAccedi.setBounds(0, 100, 640, 45);
		add(scrittaAccedi);
		
		JLabel noAccount = new JLabel("Non hai ancora un account?");
		noAccount.setFont(new Font("Arial", Font.ITALIC, 20));
		noAccount.setHorizontalAlignment(JLabel.LEFT);
		noAccount.setBounds(110, 587, 300, 25);
		add(noAccount);
		
		PasswordRecoveryLabel RecuperaPassword = new PasswordRecoveryLabel(myController, thisFrame);
		RecuperaPassword.setBounds(110, 390, 200, 25);
		add(RecuperaPassword);
		
		GoToRegisterLabel goToRegister = new GoToRegisterLabel(myController, thisFrame);
		goToRegister.setBounds(366, 582, 98, 30);
		add(goToRegister);
		
		matricolaComponent = new MatricolaComponent("Matricola");
		matricolaComponent.setBackground(new Color(0, 0, 0));
		matricolaComponent.setBounds(0, -5, 640, 720);
		add(matricolaComponent);

		passwordComponent = new PasswordComponent("Password");
		passwordComponent.setBounds(0, -5, 640, 720);
		add(passwordComponent);	
		
		setVisible(true);
	}
	
	public String getMatricolaLogin() {
		return matricolaComponent.getMatricola().toUpperCase();
	}
	
	public String getPasswordLogin() {
		return passwordComponent.getPassword();
	}
}