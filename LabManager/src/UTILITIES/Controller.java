package UTILITIES;

import javax.swing.JFrame;

import java.util.Random;

import DAO.TecnicoDAO;
import DTO.Tecnico;
import GUI.*;

public class Controller {
	
	private Tecnico newTecnico;
	private Tecnico tecnicoTemp;
	private TecnicoDAO tecnicoDAO;
	private String matricolaFinale;

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
	}
	
	public Controller() {
		
		LoginWindow loginWindow = new LoginWindow(this);
		loginWindow.setUndecorated(true);
		loginWindow.setVisible(true);
		
	}
	
	public Boolean CheckPasswordLength(String passwordInserted) {
		
		if(passwordInserted.length() > 7 && passwordInserted.length() < 17) {
			return true;
			
		} else return false;
		
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
	
	public Tecnico CreazioneTecnicoFinale(String matricola, CredenzialiPanel credenziali) {
		
		newTecnico = new Tecnico(this);
		
		newTecnico.setMatricola(matricola);
		newTecnico.setPassword(credenziali.getPasswordInserted());
		newTecnico.setNome(this.tecnicoTemp.getNome());
		newTecnico.setCognome(this.tecnicoTemp.getCognome());
		newTecnico.setDataNascita(this.tecnicoTemp.getDataNascita());
		newTecnico.setSesso(this.tecnicoTemp.getSesso());
		newTecnico.setCodiceFiscale(this.tecnicoTemp.getCodiceFiscale());
		newTecnico.setTelefono(this.tecnicoTemp.getTelefono());
		newTecnico.setEmail(this.tecnicoTemp.getEmail());
		
		return newTecnico;
	}
	
	public void RegisterNewUser(String newMatricola, CredenzialiPanel currentCredenziali) {
		
		Tecnico tecnicoCreato = CreazioneTecnicoFinale(newMatricola, currentCredenziali);
		TecnicoDAO tecnicoDAO = new TecnicoDAO();
		tecnicoDAO.creaTecnico(tecnicoCreato);
	}
	
	public Boolean CheckMissingPersonalInfo(AnagraficaPanel anagrafica, CredenzialiPanel credenziali) {
		
		//Checking if the fields are empty
	    if(!anagrafica.getNomeInserted().equals("") && !anagrafica.getCognomeInserted().equals("")) {
	    	if(!anagrafica.getGiornoInserted().equals("") && !anagrafica.getMeseInserted().equals("") && !anagrafica.getAnnoInserted().equals("")) {
	    		if(!anagrafica.getCFInserted().equals("")) {
	    			if(!anagrafica.getTelefonoInserted().equals("") && !anagrafica.getEmailInserted().equals("")) {
	    				
	    				//no missing info
	    				return true;
	    				
	    			} else { return false; }
	    			
	    		} else { return false; }
	    		
	    	}else { return false; }
	    	
	    }else { return false; }
	}	
	
	
	public void EndRegistration(CredenzialiPanel credenziali) {
		
		RegisterNewUser(matricolaFinale, credenziali);
		
	}
	
	public String CreazioneNuovaMatricola(TecnicoDAO CurrentTecnicoDAO) {
		
		String matricolaCompleta;
		
//		do {
			
			Random random = new Random();
			int value = random.nextInt(999999) + 1000000;
			
			matricolaCompleta = "LM" + String.valueOf(value);
			
//		} while(!CurrentTecnicoDAO.checkExistingMatricola(matricolaCompleta));
		
		return matricolaCompleta;
	}
	
	public void CreazioneTecnicoTemporanea(AnagraficaPanel anagrafica) {
		
		this.tecnicoTemp = new Tecnico(this);
		
		this.tecnicoTemp.setNome(anagrafica.getNomeInserted());
		this.tecnicoTemp.setCognome(anagrafica.getCognomeInserted());
		this.tecnicoTemp.setDataNascita(anagrafica.getDataNascitaInserted());
		this.tecnicoTemp.setSesso('M');
		this.tecnicoTemp.setCodiceFiscale(anagrafica.getCFInserted());
		this.tecnicoTemp.setTelefono(anagrafica.getTelefonoInserted());
		this.tecnicoTemp.setEmail(anagrafica.getEmailInserted());

	}
	
	public void LastRegistrationPageOpened(AnagraficaPanel anagrafica, CredenzialiPanel credenziali) {
		
		//CONTROLLO SE LA PASSWORD INSERITA
		matricolaFinale = CreazioneNuovaMatricola(tecnicoDAO);
		credenziali.setMatricolaToShow(matricolaFinale);
		credenziali.setVisible(true);
		anagrafica.setVisible(false);
		
	}
	
	public void GoAheadWithRegistration(AnagraficaPanel anagrafica, CredenzialiPanel credenziali) {
		
		if(CheckMissingPersonalInfo(anagrafica, credenziali)) {

			CreazioneTecnicoTemporanea(anagrafica);
			LastRegistrationPageOpened(anagrafica, credenziali);
			
		} else { anagrafica.datiErratiMancanti.setVisible(true); }
		
	}
	
}