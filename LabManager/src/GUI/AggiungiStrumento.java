package GUI;

import UTILITIES.Controller;

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
	public JLabel errorMessage1;
	public JLabel errorMessage2;
	
	
	private JTextField tipoStrumento;
	private JTextField tempoMax;
	private JComboBox postazioneAssegnata;
	private JTextArea descrizione;
	
	public AggiungiStrumento(Controller controller, Vector<Integer> postazioniAssociate, String tipoLaboratorio) {
		
		myController = controller;
		
		setTitle("Nuovo Strumento");
		getContentPane().setLayout(null);
		setSize(500, 475);
		setFocusable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		
		setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
		
		JLabel titolo = new JLabel("Aggiungi nuovo strumento: " + tipoLaboratorio);
		titolo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
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
		
		tipoStrumento = new JTextField();
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
		
		tempoMax = new JTextField();
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
		
		postazioneAssegnata = new JComboBox(postazioniAssociate);
		postazioneAssegnata.setFont(new Font("Arial", Font.ITALIC, 18));
		postazioneAssegnata.setBounds(220, 183, 75, 25);
		getContentPane().add(postazioneAssegnata);
		
		JLabel descrizioneText = new JLabel("• Descrizione: ");
		descrizioneText.setFont(new Font("Arial", Font.BOLD, 20));
		descrizioneText.setHorizontalAlignment(JLabel.LEFT);
		descrizioneText.setBounds(10, 230, 136, 30);
		getContentPane().add(descrizioneText);
		
		descrizione = new JTextArea();
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
		
		errorMessage1 = new JLabel("Questa postazione ha già troppi strumenti!");
		errorMessage1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		errorMessage1.setForeground(Color.RED);
		errorMessage1.setHorizontalAlignment(JLabel.CENTER);
		errorMessage1.setBounds(0, 330, 484, 29);
		errorMessage1.setVisible(false);
		getContentPane().add(errorMessage1);
		
		errorMessage2 = new JLabel("Dati inseriti errati o mancanti!");
		errorMessage2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 19));
		errorMessage2.setForeground(Color.RED);
		errorMessage2.setHorizontalAlignment(JLabel.CENTER);
		errorMessage2.setBounds(0, 330, 484, 29);
		errorMessage2.setVisible(false);
		getContentPane().add(errorMessage2);
		
////////////////////////////////////// LISTENER //////////////////////////////////////
		
		aggiungi.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.aggiungiStrumento();
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
	
	public String getTipoStrumento() {
		
		return tipoStrumento.getText();
	}
	
	public String getTempoMax() {
		
		return tempoMax.getText();
	}
	
	public Integer getPostazioneAssegnata() {
		
		return (Integer)postazioneAssegnata.getSelectedItem();
	}
	
	public String getDescrizione() {
		
		return descrizione.getText();
	}
}
