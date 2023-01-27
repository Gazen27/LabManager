package GUI;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JLabel;

public class CurrentDate extends JLabel {
	
	LocalDate date;

	public CurrentDate() {
		
		LocalDate date = LocalDate.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd - MM - yyyy");
		String formattedDate = date.format(formatter);
		
		setText(formattedDate);
		setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		setHorizontalAlignment(JLabel.CENTER);
	}
}
