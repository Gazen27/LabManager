package GUI;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

import UTILITIES.Controller;

public class StrumentiDisponibili extends JDialog {

	Controller myController;
	
	StrumentiDisponibili(Controller controller, String sedeScelta){
		
		myController = controller;
		
		setSize(600, 450);
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setBackground(new Color(235, 235, 235));
		
		JLabel title = new JLabel("Strumenti disponibili per: " + sedeScelta);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		title.setBounds(0, 13, 584, 35);
		getContentPane().add(title);
		
		JLabel line = new JLabel("       __________________________________________________________________");
		line.setFont(new Font("Arial", Font.BOLD, 15));
		line.setBounds(0, 40, 584, 20);
		getContentPane().add(line);
		
		
		ComponentTabellaStrumentiScelti tabellaStr = new ComponentTabellaStrumentiScelti(myController);
		tabellaStr.setBounds(30, 105, 800, 402);
		add(tabellaStr);
		
		
		JLabel info = new JLabel("Clicca su uno strumento per aprire la sua pagina di riepilogo");
		info.setHorizontalAlignment(JLabel.LEFT);
		info.setFont(new Font("Arial", Font.ITALIC, 20));
		info.setBounds(30, 520, 870, 30);
		add(info);
	}
}
