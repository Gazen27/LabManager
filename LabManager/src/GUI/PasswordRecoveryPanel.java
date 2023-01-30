package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;

import UTILITIES.Controller;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PasswordRecoveryPanel extends JPanel {
	
	Controller myController;
	
	MatricolaComponent matricolaComponent;
	private JTextField codiceFiscaleField;
	private JTextField telefonoField;
	private JTextField emailField;
	private PasswordComponent passwordComponent;
	public DatiErratiMancanti datiErratiMancanti;
	
	public PasswordRecoveryPanel(Controller controller, JFrame currentPage) {
		
		myController = controller;
		
		setBackground(new Color(235, 235, 235));
		setLayout(null);
		
		ExitSign exit = new ExitSign();
		exit.setBounds(610, 10, 25, 25);
		add(exit);
		
		BackArrow goBack = new BackArrow(myController, currentPage);
        goBack.setBounds(10, 680, 27, 40);
        add(goBack);
		
		JLabel pageTitle1 = new JLabel("Recupera Pasword");
		pageTitle1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 40));
		pageTitle1.setHorizontalAlignment(JLabel.LEFT);
		pageTitle1.setBounds(80, 70, 640, 45);
		
		JLabel pageTitle2 = new JLabel("Compila i campi sottostanti per recuperare il tuo account.");
		pageTitle2.setFont(new Font("Arial", Font.PLAIN, 20));
		pageTitle2.setHorizontalAlignment(JLabel.LEFT);
		pageTitle2.setBounds(80, 120, 640, 45);
		
		add(pageTitle1);
		add(pageTitle2);
		
		RecuperaButton recuperaButton = new RecuperaButton(myController, this);
		recuperaButton.setBounds(120, 620, 390, 50);
		add(recuperaButton);
		
		datiErratiMancanti = new DatiErratiMancanti();
		datiErratiMancanti.setBounds(60, 580, 515, 22);
		add(datiErratiMancanti);
		datiErratiMancanti.setVisible(false);
		
		matricolaComponent = new MatricolaComponent("Matricola");
		matricolaComponent.setFont(new Font("Arial", Font.BOLD, 20));
		matricolaComponent.setBackground(new Color(0, 0, 0));
		matricolaComponent.setBounds(-30, -40, 640, 720);
		add(matricolaComponent);
		
		JLabel codiceFiscaleLabel = new JLabel("Codice Fiscale");
		codiceFiscaleLabel.setBounds(80, 280, 160, 22);
		codiceFiscaleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		codiceFiscaleField = new JTextField();
		codiceFiscaleField.setBounds(80, 310, 390, 35);
		codiceFiscaleField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(codiceFiscaleLabel);
		add(codiceFiscaleField);
		
		JLabel telefonoLabel = new JLabel("Telefono/Cellulare");
		telefonoLabel.setBounds(80, 370, 180, 22);
		telefonoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		telefonoField = new JTextField();
		telefonoField.setBounds(80, 400, 240, 30);
		telefonoField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(telefonoLabel);
		add(telefonoField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(355, 370, 180, 22);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
		emailField = new JTextField();
		emailField.setBounds(355, 400, 240, 30);
		emailField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(emailLabel);
		add(emailField);
		
		passwordComponent = new PasswordComponent("Nuova Password");
		passwordComponent.setBounds(-30, 150, 640, 720);
		add(passwordComponent);	
		
		setVisible(true);
	}
	
	public String getMatricolaInserted() {
		return matricolaComponent.getMatricola().toUpperCase();
	}
	
	public String getCFInserted() {
		return codiceFiscaleField.getText().toUpperCase();
	}
	
	public String getTelefonoInserted() {
		return telefonoField.getText();
	}
	
	public String getEmailInserted() {
		return emailField.getText().toLowerCase();
	}
	
	public String getNewPasswordInserted() {
		return passwordComponent.getPassword();
	}
	
	public void showError() {
		
		datiErratiMancanti.setVisible(true);
	}

}
