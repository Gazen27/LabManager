package GUI;

import UTILITIES.Controller;

import javax.swing.JDialog;
import javax.swing.JLabel;

import DTO.Laboratorio;

import java.awt.Font;

import javax.swing.JButton;

public class IscrizioneLaboratorio extends JDialog {

	Controller myController;
	
	public IscrizioneLaboratorio(Controller controller, Laboratorio laboratorio) {
		
		myController = controller;
		
		setTitle("Iscrizione");
		
		setSize(500, 375);
		getContentPane().setLayout(null);
		
		JLabel iscriviti = new JLabel("Iscriviti");
		iscriviti.setFont(new Font("Arial", Font.BOLD | Font.PLAIN, 35));
		iscriviti.setBounds(20, 15, 454, 45);
		getContentPane().add(iscriviti);
		
		JLabel cod = new JLabel("Codice: " + "00" + laboratorio.getCodice());
		cod.setFont(new Font("Arial", Font.BOLD, 20));
		cod.setBounds(20, 75, 454, 30);
		getContentPane().add(cod);
		
		JLabel lab = new JLabel("Laboratorio di: " + laboratorio.getTipo());
		lab.setFont(new Font("Arial", Font.BOLD, 20));
		lab.setBounds(20, 110, 454, 30);
		getContentPane().add(lab);
		
		JLabel description = new JLabel(laboratorio.getDescrizione());
		description.setFont(new Font("Arial", Font.ITALIC, 16));
		description.setBounds(20, 140, 454, 25);
		getContentPane().add(description);
		
		JLabel sedeScelta = new JLabel("Sede selezionata: " + laboratorio.getSede());
		sedeScelta.setFont(new Font("Arial", Font.BOLD, 20));
		sedeScelta.setBounds(20, 190, 454, 30);
		getContentPane().add(sedeScelta);
		
		JLabel numTecnici = new JLabel("Tecnici iscritti: " + laboratorio.getNumeroTecnici());
		numTecnici.setFont(new Font("Arial", Font.BOLD, 20));
		numTecnici.setBounds(20, 225, 454, 30);
		getContentPane().add(numTecnici);
	}
}
