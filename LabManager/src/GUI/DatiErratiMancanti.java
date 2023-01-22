package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class DatiErratiMancanti extends JLabel {
	
	public DatiErratiMancanti() {
		
		setText("Dati inseriti errati o mancanti!");
		setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.RED);
	}

}
