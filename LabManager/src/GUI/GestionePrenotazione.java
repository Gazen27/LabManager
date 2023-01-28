package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DTO.PrenotazionePersonale;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

public class GestionePrenotazione extends JDialog {

	Controller myController;
	
	private JTextField tempoPrenotatoField;
	private DataComponent dataComponent;
	
	public GestionePrenotazione(Controller controller, PrenotazionePersonale prenotazione) {
		
		myController = controller;
		
		Color sfondo = new Color(235, 235, 235);
		Color buttonColor = new Color(10, 100 ,255);
		
		setSize(600, 500);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBackground(sfondo);
		setVisible(false);
		
		setTitle("Gestisci prenotazione");
		
		JLabel prenotazioneNumero = new JLabel("• Codice prenotazione: " + prenotazione.getCodicePrenotazione());
		prenotazioneNumero.setFont(new Font("Arial", Font.BOLD, 25));
		prenotazioneNumero.setHorizontalAlignment(JLabel.LEFT);
		prenotazioneNumero.setBounds(15, 15, 352, 35);
		getContentPane().add(prenotazioneNumero);
		
		JLabel line1 = new JLabel("   ____________________________________________________________________");
		line1.setFont(new Font("Arial", Font.BOLD, 15));
		line1.setBounds(10, 45, 564, 20);
		getContentPane().add(line1);
		
		JLabel strumentoPrenotato = new JLabel("• Strumento prenotato: " + prenotazione.getStrumentoCompleto());
		strumentoPrenotato.setFont(new Font("Arial", Font.BOLD, 25));
		strumentoPrenotato.setHorizontalAlignment(JLabel.LEFT);
		strumentoPrenotato.setBounds(15, 70, 569, 35);
		getContentPane().add(strumentoPrenotato);
		
		JLabel datiLaboratorio = new JLabel("• Laboratorio: " + prenotazione.getLaboratorioSede());
		datiLaboratorio.setFont(new Font("Arial", Font.BOLD, 25));
		datiLaboratorio.setHorizontalAlignment(JLabel.LEFT);
		datiLaboratorio.setBounds(15, 115, 569, 35);
		getContentPane().add(datiLaboratorio);
		
		JLabel postazioneNumero = new JLabel("• Postazione numero: " + prenotazione.getPostazioneAssegnata());
		postazioneNumero.setFont(new Font("Arial", Font.BOLD, 25));
		postazioneNumero.setHorizontalAlignment(JLabel.LEFT);
		postazioneNumero.setBounds(15, 160, 352, 35);
		getContentPane().add(postazioneNumero);
		
		JLabel line2 = new JLabel("   ____________________________________________________________________");
		line2.setFont(new Font("Arial", Font.BOLD, 15));
		line2.setBounds(10, 190, 564, 20);
		getContentPane().add(line2);
		
		JLabel orePrenotate = new JLabel("• Tempo prenotato:");
		orePrenotate.setFont(new Font("Arial", Font.BOLD, 25));
		orePrenotate.setHorizontalAlignment(JLabel.LEFT);
		orePrenotate.setBounds(15, 230, 227, 35);
		getContentPane().add(orePrenotate);
		
		tempoPrenotatoField = new JTextField(prenotazione.getTempoPrenotato().toString());
		tempoPrenotatoField.setHorizontalAlignment(JTextField.RIGHT);
		tempoPrenotatoField.setFont(new Font("Arial", Font.PLAIN, 25));
		tempoPrenotatoField.setBounds(250, 233, 50, 30);
		getContentPane().add(tempoPrenotatoField);
		
		JLabel ore = new JLabel("ore");
		ore.setFont(new Font("Arial", Font.ITALIC, 25));
		ore.setHorizontalAlignment(JLabel.LEFT);
		ore.setBounds(305, 230, 227, 35);
		getContentPane().add(ore);
		
		JLabel dataPrenotata = new JLabel("• Data prenotazione:");
		dataPrenotata.setFont(new Font("Arial", Font.BOLD, 25));
		dataPrenotata.setHorizontalAlignment(JLabel.LEFT);
		dataPrenotata.setBounds(15, 280, 254, 35);
		getContentPane().add(dataPrenotata);
		
		dataComponent = new DataComponent(null, myController);
		dataComponent.setBounds(200, -28, 316, 358);
		dataComponent.setGiorno(prenotazione.getSingoloGiorno());
		dataComponent.setMese(prenotazione.getSingoloMese());
		dataComponent.setAnno(prenotazione.getSingoloAnno());
		getContentPane().add(dataComponent);
		
	}
}
