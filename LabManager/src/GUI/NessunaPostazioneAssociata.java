package GUI;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NessunaPostazioneAssociata extends JDialog{

	public NessunaPostazioneAssociata() {
		
		setSize(350, 160);
		setBackground(new Color(235, 235, 235));
		getContentPane().setLayout(null);
		setAlwaysOnTop(true);
		setModalityType(JDialog.ModalityType.APPLICATION_MODAL);
		
		JLabel message1 = new JLabel("Non esistono postazioni associate");
		message1.setHorizontalAlignment(JLabel.CENTER);
		message1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		message1.setBounds(0, 15, 334, 25);
		getContentPane().add(message1);
		
		JLabel message2 = new JLabel("alla sede di cui sei responsabile");
		message2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		message2.setHorizontalAlignment(JLabel.CENTER);
		message2.setBounds(0, 40, 334, 25);
		getContentPane().add(message2);
		
		JButton okButton = new JButton("OK");
		okButton.setBackground(new Color(10, 100, 255));
		okButton.setForeground(Color.WHITE);
		okButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		okButton.setFocusable(false);
		okButton.setBounds(125, 77, 75, 30);
		getContentPane().add(okButton);
		
		
		okButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				okButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
				okButton.setBackground(new Color(0, 75, 210));
			}
			public void mouseExited(MouseEvent e) {
				okButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
				okButton.setBackground(new Color(10, 100, 255));
			}
		});
	}
}
