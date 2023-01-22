package GUI;

import UTILITIES.Controller;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class CurrentDate extends JLabel {
	
	private SimpleDateFormat sdf;
	private String date;

	public CurrentDate() {
		
		sdf = new SimpleDateFormat("dd / MM / yyyy");
		date = sdf.format(new Date());
		
		setText(date);
		setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
