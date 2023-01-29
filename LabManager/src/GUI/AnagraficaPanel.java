package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import UTILITIES.Controller;

public class AnagraficaPanel extends JPanel {
	
	Controller myController;
	private JTextField nomeField;
	private JTextField cognomeField;
	private DataComponent dataComponent;
	private JComboBox sessoComboBox;
	private JTextField codiceFiscaleField;
	private JTextField telefonoField;
	private JTextField emailField;
	public DatiErratiMancanti datiErratiMancanti;

	public AnagraficaPanel(Controller controller, JFrame currentRegister, CredenzialiPanel currentCredenziali) {
		
		myController = controller;
		
		setLayout(null);
		
		JLabel scrittaRegistrati = new JLabel("Registrati");
		scrittaRegistrati.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 50));
		scrittaRegistrati.setHorizontalAlignment(JLabel.CENTER);
		scrittaRegistrati.setBounds(0, 80, 640, 55);
		add(scrittaRegistrati);
		
		BackArrow goBack = new BackArrow(myController, currentRegister);
        goBack.setBounds(10, 680, 27, 40);
        add(goBack);
		
		AvantiButton avantiButton = new AvantiButton(myController, this, currentCredenziali);
		avantiButton.setBounds(110, 620, 390, 50);
		add(avantiButton);
		
		datiErratiMancanti = new DatiErratiMancanti();
		datiErratiMancanti.setBounds(40, 561, 515, 22);
		add(datiErratiMancanti);
		datiErratiMancanti.setVisible(false);
		
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setBounds(65, 190, 120, 22);
		nomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		nomeField = new JTextField();
		nomeField.setBounds(65, 220, 240, 30);
		nomeField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(nomeLabel);
		add(nomeField);
		
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setBounds(340, 190, 120, 22);
		cognomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		cognomeField = new JTextField();
		cognomeField.setBounds(340, 220, 240, 30);
		cognomeField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(cognomeLabel);
		add(cognomeField);
		
		dataComponent = new DataComponent("Data di Nascita", myController);
		dataComponent.setBackground(new Color(0, 0, 0));
		dataComponent.setBounds(0, 0, 640, 720);
		add(dataComponent);
		
		JLabel sessoLabel = new JLabel("Sesso");
		sessoLabel.setBounds(340, 280, 160, 22);
		sessoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		String[] genderList = {"Uomo", "Donna"};
		sessoComboBox = new JComboBox(genderList);
		sessoComboBox.setBounds(340, 310, 240, 30);
		sessoComboBox.setFont(new Font("Arial", Font.PLAIN, 17));
		add(sessoLabel);
		add(sessoComboBox);
		
		JLabel codiceFiscaleLabel = new JLabel("Codice Fiscale");
		codiceFiscaleLabel.setBounds(65, 370, 160, 22);
		codiceFiscaleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		codiceFiscaleField = new JTextField();
		codiceFiscaleField.setBounds(65, 400, 515, 30);
		codiceFiscaleField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(codiceFiscaleLabel);
		add(codiceFiscaleField);
		
		JLabel telefonoLabel = new JLabel("Telefono/Cellulare");
		telefonoLabel.setBounds(65, 460, 180, 22);
		telefonoLabel.setFont(new Font("Arial", Font.BOLD, 20));
		telefonoField = new JTextField();
		telefonoField.setBounds(65, 490, 240, 30);
		telefonoField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(telefonoLabel);
		add(telefonoField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(340, 460, 180, 22);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 20));
		emailField = new JTextField();
		emailField.setBounds(340, 490, 240, 30);
		emailField.setFont(new Font("Arial", Font.PLAIN, 17));
		add(emailLabel);
		add(emailField);
		
		//Focus on the Name Field
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          nomeField.requestFocus();
	        }
	      });
	    
	}
	
	public String getNomeInserted() {
		return nomeField.getText();
	}
	
	public String getCognomeInserted() {
		return cognomeField.getText();
	}
	
	public String getGiornoInserted() {
		
		return this.dataComponent.getGiorno();
	}
	
	public String getMeseInserted() {
		return this.dataComponent.getMese();
	}
	
	public String getAnnoInserted() {
		return this.dataComponent.getAnno();
	}
	
	public String getDataNascitaInserted() {
		return this.dataComponent.getDataCompleta();
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
	
	public char getSessoInserted() {
		
		String sesso = (String)sessoComboBox.getSelectedItem();
		
		if(sesso.equals("Uomo")) {
			
			return 'M';
			
		} else { return 'F'; }

	}

}
