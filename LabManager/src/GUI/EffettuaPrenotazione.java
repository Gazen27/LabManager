package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DTO.Strumento;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class EffettuaPrenotazione extends JDialog {
	
	Controller myController;
	
	private Integer codice;
	private String tipo;
	private Integer postazione;
	private Integer oreMax;
	private String descrizione;
	
	private JTextField tempoField;
	private DataComponent dataFields;
	
	public JLabel dataEsistente;
	public JLabel datiMancantiErrrati;
	public JLabel title;
	
	private Integer year;
	private Integer month;
	private Integer day;
	
	private LocalDate today = LocalDate.now();
	
	public EffettuaPrenotazione(Controller controller, Strumento strumento) {
		
		myController = controller;
		
		codice = strumento.getCodice();
		tipo =  strumento.getTipo();
		postazione = strumento.getPostazioneAssegnata();
		oreMax = Integer.parseInt(strumento.getMaxUtilizzo());
		descrizione = strumento.getDescrizione();

		
		Color sfondo = new Color(235, 235, 235);
		
		setSize(520, 450);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBackground(sfondo);
		
		title = new JLabel("Nuova prenotazione");
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setBounds(0, 10, 504, 39);
		title.setVisible(true);
		getContentPane().add(title);
		
		JLabel strumentoDaPrenotare = new JLabel("• Strumento: 00" + codice + " - " + tipo);
		strumentoDaPrenotare.setFont(new Font("Arial", Font.BOLD, 22));
		strumentoDaPrenotare.setHorizontalAlignment(JLabel.LEFT);
		strumentoDaPrenotare.setBounds(10, 60, 464, 30);
		getContentPane().add(strumentoDaPrenotare);
		
		JLabel postazioneText = new JLabel("• Postazione assegnata: 00" + postazione);
		postazioneText.setFont(new Font("Arial", Font.BOLD, 22));
		postazioneText.setHorizontalAlignment(JLabel.LEFT);
		postazioneText.setBounds(10, 105, 464, 30);
		getContentPane().add(postazioneText);
		
		JLabel oreMaxText = new JLabel("• Tempo massimo di utilizzo: " + oreMax + " ore");
		oreMaxText.setFont(new Font("Arial", Font.BOLD, 22));
		oreMaxText.setHorizontalAlignment(JLabel.LEFT);
		oreMaxText.setBounds(10, 150, 464, 30);
		getContentPane().add(oreMaxText);
		
		JLabel descrizioneTitle = new JLabel("• Descrizione:");
		descrizioneTitle.setFont(new Font("Arial", Font.BOLD, 22));
		descrizioneTitle.setHorizontalAlignment(JLabel.LEFT);
		descrizioneTitle.setBounds(10, 195, 464, 30);
		getContentPane().add(descrizioneTitle);
		
		JLabel descrizioneText = new JLabel(descrizione);
		descrizioneText.setFont(new Font("Arial", Font.ITALIC, 20));
		descrizioneText.setBackground(sfondo);
		descrizioneText.setBounds(10, 230, 464, 30);
		getContentPane().add(descrizioneText);
		
		
		JLabel line = new JLabel("   _______________________________________________________");
		line.setFont(new Font("Arial", Font.BOLD, 15));
		line.setBounds(14, 255, 460, 20);
		getContentPane().add(line);
		
		JLabel dataPrenotazione = new JLabel("• Data di prenotazione:");
		dataPrenotazione.setFont(new Font("Arial", Font.BOLD, 22));
		dataPrenotazione.setHorizontalAlignment(JLabel.LEFT);
		dataPrenotazione.setBounds(10, 290, 464, 30);
		getContentPane().add(dataPrenotazione);
		
		dataFields = new DataComponent(null, myController);
		dataFields.setBounds(185, -18, 319, 435);
		getContentPane().add(dataFields);
		
		JLabel tempoPrenotato = new JLabel("• Tempo prenotato:");
		tempoPrenotato.setFont(new Font("Arial", Font.BOLD, 22));
		tempoPrenotato.setHorizontalAlignment(JLabel.LEFT);
		tempoPrenotato.setBounds(10, 340, 464, 30);
		getContentPane().add(tempoPrenotato);
		
		tempoField = new JTextField();
		tempoField.setFont(new Font("Arial", Font.PLAIN, 22));
		tempoField.setHorizontalAlignment(JLabel.RIGHT);
		tempoField.setBounds(215, 340, 50, 30);
		getContentPane().add(tempoField);
		
		JLabel oreText = new JLabel("ore");
		oreText.setFont(new Font("Arial", Font.ITALIC, 20));
		oreText.setHorizontalAlignment(JLabel.LEFT);
		oreText.setBounds(267, 340, 40, 30);
		getContentPane().add(oreText);

		
		JButton prenotaButton = new JButton("Prenota");
		prenotaButton.setFont(new Font("Segoe UI", Font.BOLD, 17));
		prenotaButton.setForeground(Color.WHITE);
		prenotaButton.setBackground(new Color(10, 100, 255));
		prenotaButton.setBounds(340, 340, 130, 53);
		getContentPane().add(prenotaButton);
		
		datiMancantiErrrati = new JLabel("Dati mancanti o errati!");
		datiMancantiErrrati.setHorizontalAlignment(JLabel.CENTER);
		datiMancantiErrrati.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		datiMancantiErrrati.setForeground(Color.RED);
		datiMancantiErrrati.setBounds(0, 10, 504, 39);
		datiMancantiErrrati.setVisible(false);
		getContentPane().add(datiMancantiErrrati);
		
		
		dataEsistente = new JLabel("Strumento già occupato nella data inserita!");
		dataEsistente.setHorizontalAlignment(JLabel.CENTER);
		dataEsistente.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		dataEsistente.setForeground(Color.RED);
		dataEsistente.setBounds(0, 10, 504, 39);
		dataEsistente.setVisible(false);
		getContentPane().add(dataEsistente);

		
		prenotaButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if(myController.prenotazioneCompleted()) {
					
					if(!getDataInserted().isBefore(today)) {
						
						if(!(getTempoInserted() > oreMax)) {
							
							myController.prenotaStrumento(strumento, getTempoInserted(), getDataInserted());
							
						} else {
							
							datiMancantiErrrati.setVisible(true);
							dataEsistente.setVisible(false);
							title.setVisible(false);
						}
						
					} else {
						
						datiMancantiErrrati.setVisible(true);
						dataEsistente.setVisible(false);
						title.setVisible(false);
					}
					
				} else {
					
					datiMancantiErrrati.setVisible(true);
					dataEsistente.setVisible(false);
					title.setVisible(false);
				}
				
			}
			
			public void mouseEntered(MouseEvent e) {
				prenotaButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
				prenotaButton.setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				prenotaButton.setFont(new Font("Segoe UI", Font.BOLD, 17));;
				prenotaButton.setBackground(new Color(10, 100, 255));
			}
		});
	}
	
	
	
	public Integer getTempoInserted() {
		
		Integer tempo = Integer.parseInt(tempoField.getText());
		
		return tempo;
	}
	
	
	public LocalDate getDataInserted() {
		
		year = Integer.parseInt(dataFields.getAnno());
		month = Integer.parseInt(dataFields.getMese());
		day = Integer.parseInt(dataFields.getGiorno());
		
		LocalDate data = LocalDate.of(year, month, day);
		
		return data;
	}
	
	
	public String getCampoTempo() {
		
		return tempoField.getText();
	}
	
	
	public String getCampoDay() {
		
		return dataFields.getGiorno();
	}
	
	public String getCampoMonth() {
		
		return dataFields.getMese();
	}

	
	public String getCampoYear() {
		
		return dataFields.getAnno();
	}


}
