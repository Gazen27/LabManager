package GUI;

import UTILITIES.Controller;
import DTO.Strumento;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class AggiungiStrumento extends JDialog {

	Controller myController;
	JLabel errorMessage;
	
	public AggiungiStrumento(Controller controller, Vector<Integer> postazioniAssociate) {
		
		myController = controller;
		
		setTitle("Nuovo Strumento");
		getContentPane().setLayout(null);
		setSize(500, 475);
		setFocusable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		
		setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
		
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
		tipoStrumento.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
		tempoMax.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
		
		JComboBox postazioneAssegnata = new JComboBox(postazioniAssociate);
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
		descrizione.setBounds(150, 233, 320, 85);
		descrizione.setLineWrap(true);
		descrizione.setWrapStyleWord(true);
		descrizione.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(descrizione);
		
		JButton aggiungi = new JButton("Aggiungi");
		aggiungi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		aggiungi.setForeground(Color.WHITE);
		aggiungi.setBackground(new Color(10, 100, 255));
		aggiungi.setBounds(85, 370, 300, 51);
		aggiungi.setFocusable(false);
		getContentPane().add(aggiungi);
		
		errorMessage = new JLabel("Questa postazione ha già troppi strumenti!");
		errorMessage.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		errorMessage.setForeground(Color.RED);
		errorMessage.setHorizontalAlignment(JLabel.CENTER);
		errorMessage.setBounds(0, 330, 484, 29);
		errorMessage.setVisible(false);
		getContentPane().add(errorMessage);
		
////////////////////////////////////// LISTENER //////////////////////////////////////
		
		aggiungi.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				
			}
			
			public void mouseEntered(MouseEvent e) {
				aggiungi.setFont(new Font("Segoe UI", Font.BOLD, 18));
				aggiungi.setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				aggiungi.setFont(new Font("Segoe UI", Font.BOLD, 20));;
				aggiungi.setBackground(new Color(10, 100, 255));
			}
		});
		
		
	}
}
