package UTILITIES;

import javax.swing.JFrame;

import GUI.*;

public class Controller {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
	}
	
	public Controller() {
		
		LoginWindow loginWindow = new LoginWindow(this);
		loginWindow.setUndecorated(true);
		loginWindow.setVisible(true);
		
	}
	
	public Boolean CheckPasswordLength(String passwordInserted) {
		
		Boolean result = false;
		
		if(passwordInserted.length() > 7 && passwordInserted.length() < 17) {
			result = true;
		}
		
		return result;
	}
	
	public void GotoLoginPage(JFrame currentPage) {
		
		LoginWindow loginWindow = new LoginWindow(this);
		loginWindow.setUndecorated(true);
		loginWindow.setVisible(true);
		
		currentPage.dispose();
	}
	
	public void GotoRegisterPage(JFrame fromLogin) {
		
		RegisterWindow registerWindow = new RegisterWindow(this);
		registerWindow.setUndecorated(true);
		registerWindow.setVisible(true);
		
		fromLogin.dispose();
	}
	
	public void GotoPasswordRecoveryPage(JFrame fromLogin) {
		
		PasswordRecoveryWindow passwordRecoveryWindow = new PasswordRecoveryWindow(this);
		passwordRecoveryWindow.setUndecorated(true);
		passwordRecoveryWindow.setVisible(true);
		
		fromLogin.dispose();
	}
	
	public void CheckMissingLoginInfo(LoginPanel login) {
		
		//Checking if the fields are empty
		if(!login.getMatricolaLogin().equals("") && !login.getPasswordLogin().equals("")) {
			
			//METHOD TO LOGIN
			
		} else { login.datiErratiMancanti.setVisible(true); }
	}
	
	public void CheckMissingRecoveryInfo(PasswordRecoveryPanel recovery) {
		
		//Checking if the fields are empty
		if(!recovery.getMatricolaInserted().equals("") && !recovery.getNewPasswordInserted().equals("")) {
			if(!recovery.getEmailInserted().equals("") && !recovery.getTelefonoInserted().equals("")) {
				if(!recovery.getCFInserted().equals("")) {
					
					//INSERIRE METODO RECUPERO PASSWORD
					
				} else { recovery.datiErratiMancanti.setVisible(true); }
				
			} else { recovery.datiErratiMancanti.setVisible(true); }
			
		} else { recovery.datiErratiMancanti.setVisible(true); }
		
	} 
	
	public void CheckMissingPersonalInfo(AnagraficaPanel anagrafica, CredenzialiPanel credenziali) {
		
		//Checking if the fields are empty
	    if(!anagrafica.getNomeInserted().equals("") && !anagrafica.getCognomeInserted().equals("")) {
	    	if(!anagrafica.getGiornoInserted().equals("") && !anagrafica.getMeseInserted().equals("") && !anagrafica.getAnnoInserted().equals("")) {
	    		if(!anagrafica.getCFInserted().equals("")) {
	    			if(!anagrafica.getTelefonoInserted().equals("") && !anagrafica.getEmailInserted().equals("")) {
	    				
	    				credenziali.setVisible(true);
	    				anagrafica.setVisible(false);
	    				//INSERIRE METODO GENERAZIONE MATRICOLA
	    				
	    			} else { anagrafica.datiErratiMancanti.setVisible(true); }
	    			
	    		} else { anagrafica.datiErratiMancanti.setVisible(true); }
	    		
	    	}else { anagrafica.datiErratiMancanti.setVisible(true); }
	    	
	    }else { anagrafica.datiErratiMancanti.setVisible(true); }
		
	}
	
}