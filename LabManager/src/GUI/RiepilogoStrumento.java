package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;

import DTO.Storico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RiepilogoStrumento extends JDialog {

	Controller myController;
	
	public RiepilogoStrumento(Controller controller, Storico storico) {
		
		myController = controller;
		
		Color sfondo = new Color(235, 235, 235);
		Color coloreMese = new Color(25, 175, 25);
		Color coloreAnno = new Color(35, 35, 185);
		Color buttonColor = new Color(10, 100, 255);
		
		setSize(700, 450);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBackground(sfondo);
		setVisible(false);
		
		JLabel line1 = new JLabel("      ________________________________________________________________________________");
		line1.setFont(new Font("Arial", Font.BOLD, 15));
		line1.setBounds(0, 45, 684, 20);
		getContentPane().add(line1);
		
		JLabel strumentoStorico = new JLabel("00" + storico.getCodiceStrumento() + " - " + storico.getTipoStrumento());
		strumentoStorico.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
		strumentoStorico.setHorizontalAlignment(JLabel.CENTER);
		strumentoStorico.setBounds(0, 15, 690, 35);
		getContentPane().add(strumentoStorico);
		
		JLabel utilizzoMese = new JLabel("• Tempo di utilizzo questo mese: " + storico.getUtilizzoMese() + " ore");
		utilizzoMese.setFont(new Font("Arial", Font.BOLD, 25));
		utilizzoMese.setHorizontalAlignment(JLabel.LEFT);
		utilizzoMese.setForeground(coloreMese);
		utilizzoMese.setBounds(10, 85, 500, 35);
		getContentPane().add(utilizzoMese);
		
		JLabel tecnicoMese = new JLabel("• Utilizzatore del mese: " + storico.getTopUtilizzatoreMese());
		tecnicoMese.setFont(new Font("Arial", Font.BOLD, 25));
		tecnicoMese.setHorizontalAlignment(JLabel.LEFT);
		tecnicoMese.setForeground(coloreMese);
		tecnicoMese.setBounds(10, 135, 500, 35);
		getContentPane().add(tecnicoMese);
		
		JLabel line2 = new JLabel("      ________________________________________________________________________________");
		line2.setFont(new Font("Arial", Font.BOLD, 15));
		line2.setBounds(0, 175, 684, 20);
		getContentPane().add(line2);
		
		JLabel utilizzoAnno = new JLabel("• Tempo di utilizzo quest'anno: " + storico.getUtilizzoAnno() + " ore");
		utilizzoAnno.setFont(new Font("Arial", Font.BOLD, 25));
		utilizzoAnno.setHorizontalAlignment(JLabel.LEFT);
		utilizzoAnno.setForeground(coloreAnno);
		utilizzoAnno.setBounds(10, 205, 500, 35);
		getContentPane().add(utilizzoAnno);
		
		JLabel tecnicoAnno = new JLabel("• Utilizzatore dell'anno: " + storico.getTopUtilizzatoreAnno());
		tecnicoAnno.setFont(new Font("Arial", Font.BOLD, 25));
		tecnicoAnno.setHorizontalAlignment(JLabel.LEFT);
		tecnicoAnno.setForeground(coloreAnno);
		tecnicoAnno.setBounds(10, 255, 500, 35);
		getContentPane().add(tecnicoAnno);
		
		JLabel line3 = new JLabel("      ________________________________________________________________________________");
		line3.setFont(new Font("Arial", Font.BOLD, 15));
		line3.setBounds(0, 295, 684, 20);
		getContentPane().add(line3);
		
		JButton calendario = new JButton("Calendario prenotazioni");
		calendario.setFont(new Font("Segoe UI", Font.BOLD, 25));
		calendario.setForeground(Color.WHITE);
		calendario.setBackground(buttonColor);
		calendario.setBounds(160, 330, 339, 62);
		calendario.setFocusable(false);
		getContentPane().add(calendario);
		
		calendario.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.openCalendario(storico.getCodiceStrumento(), storico.getTipoStrumento());
			}
			
			public void mouseEntered(MouseEvent e) {
				calendario.setBackground(new Color(0, 75, 210));
				calendario.setFont(new Font("Segoe UI", Font.BOLD, 23));
			}
			
			public void mouseExited(MouseEvent e) {
				calendario.setBackground(buttonColor);
				calendario.setFont(new Font("Segoe UI", Font.BOLD, 25));
			}
		});
	}
}
