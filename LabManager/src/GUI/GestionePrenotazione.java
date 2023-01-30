package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DTO.PrenotazionePersonale;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DateTimeException;
import java.time.LocalDate;

public class GestionePrenotazione extends JDialog {

	Controller myController;
	
	private JTextField tempoPrenotatoField;
	private DataComponent dataComponent;
	private JLabel datiErratiMancanti; 
	private Integer oreMax;
	private String mySubstring;
	private Integer codiceStrumento;
	private JLabel dataOccupata;
	
	public GestionePrenotazione(Controller controller, PrenotazionePersonale prenotazione) {
		
		myController = controller;
		
		oreMax = prenotazione.getTempoMaxStrumento();
		
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
		
		datiErratiMancanti = new JLabel("Dati inseriti non validi o mancanti!");
		datiErratiMancanti.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		datiErratiMancanti.setForeground(Color.RED);
		datiErratiMancanti.setHorizontalAlignment(JLabel.CENTER);
		datiErratiMancanti.setBounds(0, 330, 584, 35);
		datiErratiMancanti.setVisible(false);
		getContentPane().add(datiErratiMancanti);
		
		dataOccupata = new JLabel("Quella data è già occupata!");
		dataOccupata.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		dataOccupata.setForeground(Color.RED);
		dataOccupata.setHorizontalAlignment(JLabel.CENTER);
		dataOccupata.setBounds(0, 330, 584, 35);
		dataOccupata.setVisible(false);
		getContentPane().add(dataOccupata);
		
		JButton conferma = new JButton("Conferma modifiche");
		conferma.setFont(new Font("Segoe UI", Font.BOLD, 25));
		conferma.setForeground(Color.WHITE);
		conferma.setBackground(buttonColor);
		conferma.setBounds(130, 376, 304, 62);
		conferma.setFocusable(false);
		getContentPane().add(conferma);
		
		mySubstring = prenotazione.getStrumentoCompleto().substring(0, 3);
		codiceStrumento = Integer.parseInt(mySubstring);
		
		LocalDate dateCheck = LocalDate.of(1900, 01, 01);
		
		
		conferma.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if(myController.campiGestioneCompleted()) {
					
					if(!(getTempoInt() > oreMax)) {
						
						if(myController.checkDate(codiceStrumento)) {
							
							if(!getDataUpdated().equals(dateCheck)) {
								
								myController.aggiornaPrenotazione(prenotazione.getCodicePrenotazione(), getTempoInt(), getDataUpdated());
								
							} else { 
								
								dataOccupata.setVisible(false);
								datiErratiMancanti.setVisible(true);
							}
							
						} else {
							
							datiErratiMancanti.setVisible(false);
							dataOccupata.setVisible(true);
						}
						
						
					} else { 
						
						dataOccupata.setVisible(false);
						datiErratiMancanti.setVisible(true);
					}
					
					
				} else { 
					
					dataOccupata.setVisible(false);
					datiErratiMancanti.setVisible(true);
				}
				
			}
			
			public void mouseEntered(MouseEvent e) {
				conferma.setBackground(new Color(0, 75, 210));
				conferma.setFont(new Font("Segoe UI", Font.BOLD, 23));
			}
			
			public void mouseExited(MouseEvent e) {
				conferma.setBackground(new Color(10, 100, 255));
				conferma.setFont(new Font("Segoe UI", Font.BOLD, 25));
			}
		});
	}
	
	public String getDay() {
		
		return dataComponent.getGiorno();
	}
	
	public String getMonth() {
		
		return dataComponent.getMese();
	}
	
	public String getYear() {
		
		return dataComponent.getAnno();
	}
	
	public String getTempoInserted() {
		
		return tempoPrenotatoField.getText();
	}
	
	public Integer getTempoInt() {
		
		Integer time = Integer.parseInt(getTempoInserted());
		return time;
	}
	
	public LocalDate getDataUpdated() {
		
		Integer year = Integer.parseInt(dataComponent.getAnno());
		Integer month = Integer.parseInt(dataComponent.getMese());
		Integer day = Integer.parseInt(dataComponent.getGiorno());
		
		LocalDate data = LocalDate.of(1900, 01, 01);
		
		try {
			
			data = LocalDate.of(year, month, day);
			return data;
			
		} catch (DateTimeException e) {
			
			return data;
		}
		
	}
	
}
