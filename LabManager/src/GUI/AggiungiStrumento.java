package GUI;

import UTILITIES.Controller;
import DTO.Strumento;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;

public class AggiungiStrumento extends JDialog {

	Controller myController;
	
	public AggiungiStrumento(Controller controller) {
		
		myController = controller;
		
		setTitle("Nuovo Strumento");
		getContentPane().setLayout(null);
		setSize(500, 350);
		setFocusable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		
		JLabel titolo = new JLabel("Aggiungi nuovo strumento");
		titolo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setBounds(0, 15, 500, 35);
		getContentPane().add(titolo);
		
		JLabel line = new JLabel("   _______________________________________________________");
		line.setFont(new Font("Arial", Font.BOLD, 15));
		line.setBounds(10, 40, 460, 20);
		getContentPane().add(line);
		
		JLabel tipoStrumentoText = new JLabel("• Tipo: ");
		tipoStrumentoText.setFont(new Font("Arial", Font.BOLD, 20));
		tipoStrumentoText.setHorizontalAlignment(JLabel.LEFT);
		tipoStrumentoText.setBounds(10, 80, 75, 30);
		getContentPane().add(tipoStrumentoText);
		
		JTextField tipoStrumento = new JTextField();
		tipoStrumento.setFont(new Font("Arial", Font.PLAIN, 18));
		tipoStrumento.setHorizontalAlignment(JTextField.LEFT);
		tipoStrumento.setBounds(85, 83, 215, 25);
		getContentPane().add(tipoStrumento);
		
		JLabel tempoMaxText = new JLabel("• Tempo di utilizzo massimo: ");
		tempoMaxText.setFont(new Font("Arial", Font.BOLD, 20));
		tempoMaxText.setHorizontalAlignment(JLabel.LEFT);
		tempoMaxText.setBounds(10, 130, 276, 30);
		getContentPane().add(tempoMaxText);
		
		JTextField tempoMax = new JTextField();
		tempoMax.setFont(new Font("Arial", Font.PLAIN, 18));
		tempoMax.setHorizontalAlignment(JTextField.RIGHT);
		tempoMax.setBounds(290, 133, 50, 25);
		getContentPane().add(tempoMax);
		
		JLabel oreText = new JLabel("ore");
		oreText.setFont(new Font("Arial", Font.ITALIC, 20));
		oreText.setHorizontalAlignment(JLabel.LEFT);
		oreText.setBounds(346, 130, 50, 30);
		getContentPane().add(oreText);
		
		JLabel codicePostazione = new JLabel("• Codice postazione: ");
		codicePostazione.setFont(new Font("Arial", Font.BOLD, 20));
		codicePostazione.setHorizontalAlignment(JLabel.LEFT);
		codicePostazione.setBounds(10, 180, 200, 30);
		getContentPane().add(codicePostazione);
		
		JComboBox postazioneAssegnata = new JComboBox();
		postazioneAssegnata.setFont(new Font("Arial", Font.ITALIC, 18));
		postazioneAssegnata.setBounds(220, 183, 75, 25);
		getContentPane().add(postazioneAssegnata);
		
		JLabel descrizioneText = new JLabel("• Descrizione: ");
		descrizioneText.setFont(new Font("Arial", Font.BOLD, 20));
		descrizioneText.setHorizontalAlignment(JLabel.LEFT);
		descrizioneText.setBounds(10, 230, 136, 30);
		getContentPane().add(descrizioneText);
		
		JTextArea descrizione = new JTextArea();
		descrizione.setFont(new Font("Arial", Font.PLAIN, 18));
		descrizione.setBounds(150, 233, 320, 67);
		descrizione.setLineWrap(true);
		descrizione.setWrapStyleWord(true);
		getContentPane().add(descrizione);
		
		//TODO: adding listeners and buttons. resizing the JDialog.
	}
}
