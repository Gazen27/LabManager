package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;

import DTO.Storico;

import java.awt.Color;
import java.awt.Font;

public class RiepilogoStrumento extends JDialog {

	Controller myController;
	
	public RiepilogoStrumento(Controller controller, Storico storico) {
		
		myController = controller;
		
		Color sfondo = new Color(235, 235, 235);
		Color coloreMese = new Color(25, 175, 25);
		Color coloreAnno = new Color(25, 25, 175);
		
		setSize(700, 550);
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
	}
}
