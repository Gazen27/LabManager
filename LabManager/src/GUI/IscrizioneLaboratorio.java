package GUI;

import UTILITIES.Controller;
import UTILITIES.Session;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import DTO.Laboratorio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class IscrizioneLaboratorio extends JDialog {

	Controller myController;
	
	public IscrizioneLaboratorio(Controller controller, Laboratorio laboratorio, Boolean notIscritto) {
		
		myController = controller;
		
		setTitle("Iscrizione");
		
		setSize(500, 360);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel line = new JLabel("   _______________________________________________________");
		line.setFont(new Font("Arial", Font.BOLD, 15));
		line.setBounds(10, 105, 460, 20);
		getContentPane().add(line);

		JLabel cod = new JLabel("Codice: " + "00" + laboratorio.getCodice());
		cod.setFont(new Font("Arial", Font.BOLD, 20));
		cod.setBounds(20, 22, 245, 30);
		getContentPane().add(cod);
		
		JLabel lab = new JLabel("Laboratorio di: " + laboratorio.getTipo());
		lab.setFont(new Font("Arial", Font.BOLD, 20));
		lab.setBounds(20, 52, 330, 30);
		getContentPane().add(lab);
		
		JLabel description = new JLabel(laboratorio.getDescrizione());
		description.setFont(new Font("Arial", Font.ITALIC, 16));
		description.setBounds(20, 82, 454, 25);
		getContentPane().add(description);
		
		JLabel sedeScelta = new JLabel("Sede selezionata: " + laboratorio.getSede());
		sedeScelta.setFont(new Font("Arial", Font.BOLD, 20));
		sedeScelta.setBounds(20, 136, 283, 30);
		getContentPane().add(sedeScelta);
		
		JLabel numTecnici = new JLabel("Tecnici iscritti: " + laboratorio.getNumeroTecnici());
		numTecnici.setFont(new Font("Arial", Font.BOLD, 20));
		numTecnici.setBounds(20, 165, 283, 30);
		getContentPane().add(numTecnici);
		
		
		JButton responsabileButton = new JButton("Responsabile?");
		responsabileButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		responsabileButton.setForeground(Color.WHITE);
		responsabileButton.setBackground(new Color(10, 100, 255));
		responsabileButton.setBounds(324, 144, 137, 51);
		responsabileButton.setFocusable(false);
		responsabileButton.setEnabled(false);
		getContentPane().add(responsabileButton);
		
		if(!responsabileButton.isEnabled()) {
			
			responsabileButton.setOpaque(false);
			
		} else {
			
			responsabileButton.setOpaque(true);
			responsabileButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		}
		
		
		JButton disiscrivitiButton = new JButton("ANNULLA ISCRIZIONE");
		disiscrivitiButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		disiscrivitiButton.setForeground(Color.WHITE);
		disiscrivitiButton.setBackground(new Color(10, 100, 255));
		disiscrivitiButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		disiscrivitiButton.setBounds(110, 230, 250, 65);
		disiscrivitiButton.setFocusable(false);
		
		
		JButton iscrivitiButton = new JButton("ISCRIVITI");
		iscrivitiButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		iscrivitiButton.setForeground(Color.WHITE);
		iscrivitiButton.setBackground(new Color(10, 100, 255));
		iscrivitiButton.setBorder(BorderFactory.createLineBorder(new Color(10, 100, 255), 1, true));
		iscrivitiButton.setBounds(110, 230, 250, 65);
		iscrivitiButton.setFocusable(false);
		
		if(notIscritto) {
			
			getContentPane().add(iscrivitiButton);
			
		} else {
			
			getContentPane().add(disiscrivitiButton);

		}
		
		
////////////////////////////////////// LISTENER //////////////////////////////////////
		
		
		iscrivitiButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				myController.executeIscrizione(laboratorio.getCodice(), laboratorio.getTipo());
			}
			
			public void mouseEntered(MouseEvent e) {
				iscrivitiButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
				iscrivitiButton.setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				iscrivitiButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
				iscrivitiButton.setBackground(new Color(10, 100, 255));
			}
		});
	}
}
