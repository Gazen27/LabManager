package UTILITIES;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Random;
import java.util.Vector;

import DAO.*;
import DTO.*;
import GUI.*;

public class Controller {
	
	private Tecnico tecnico;
	private Tecnico tecnicoTemp;
	private TecnicoDAO tecnicoDAO;
	private String matricolaFinale;
	private RegisterWindow registerWindow;
	private LoginWindow loginWindow;
	private ReturnToLoginPage toLoginDialog;
	private PasswordRecoveryWindow passwordRecoveryWindow;
	private MainWindow mainWindow;
	private Session currentSession;
	private IscrizioneLaboratorio iscriviti;
	
	private LaboratorioDAO laboratorioDAO;
	private Laboratorio laboratorioTemp;
	private SedeDAO sedeDAO;
	
	private Postazione currentPostazione;
	private PostazioneDAO postazioneDAO;
	
	private NuovaPostazione nuovaPostazione;
	private AggiungiStrumento aggiungiStrumento;
	private NessunaPostazioneAssociata nessunaPostazione;
	
	private Strumento strumentoTEMP;
	private StrumentoDAO strumentoDAO;
	
	private ScegliSede scegliSede;

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
	}
	
	public Controller() {

		loginWindow = new LoginWindow(this);
		loginWindow.setUndecorated(true);
		loginWindow.setVisible(true);

	}
	
	
////////////////////////////////////// GESTIONE LABORATORI //////////////////////////////////////
	
	public Vector<Vector<String>> infoLaboratorio() {
	

		Vector<Vector<String>> doubleVector = new Vector<Vector<String>>();
		
		laboratorioDAO = new LaboratorioDAO(this);
		
		Vector<Laboratorio> laboratori = laboratorioDAO.getAllLaboratori();
		
		for (Laboratorio l : laboratori) {
			
			Vector<String> singleVector = new Vector<String>();
			singleVector.add("00" + l.getCodice());
			singleVector.add(l.getTipo());
			singleVector.add(l.getSede());
			singleVector.add(l.getNumeroTecnici());
			
			
			doubleVector.add(singleVector);
		}
		
		return doubleVector;
	}
	
	
	public void iscrivitiLaboratorio(String cod, String tipo) {
		
		laboratorioTemp = laboratorioDAO.getSingoloLaboratorio(cod, tipo);
		
		Boolean notIscritto = this.tecnicoIscritto(cod, tipo);
		
		iscriviti = new IscrizioneLaboratorio(this, laboratorioTemp, notIscritto);
		iscriviti.setLocationRelativeTo(mainWindow);
		iscriviti.setVisible(true);
		
	}

	
	public void executeIscrizione(String codice, String tipo) {
		
		String matricola = currentSession.getUserMatricola();
		laboratorioDAO.iscrizioneTecnico(matricola, codice, tipo);
		
		iscriviti.dispose();
		
		mainWindow.dispose();
		
		mainWindow =  new MainWindow(this, currentSession);
		mainWindow.setVisible(true);
	}
	
	
	public Boolean tecnicoIscritto(String codice, String tipo) {
		
		String matricola;
		
		matricola = currentSession.getUserMatricola();
		
		if(!laboratorioDAO.isIscritto(matricola, codice, tipo)) {
			
			return true;
			
		} else { return false; }
	}
	
	
	public void deleteIscrizione(String sede, String tipo) {
		
		String matricola = currentSession.getUserMatricola();
		laboratorioDAO.cancellaIscrizione(matricola, sede, tipo);
		
		iscriviti.dispose();
		mainWindow.dispose();
		
		mainWindow =  new MainWindow(this, currentSession);
		mainWindow.setVisible(true);
		
	}
	
	
	public void becomeResponsabile(String sede, String tipo) {
		
		String matricola = currentSession.getUserMatricola();
		laboratorioDAO.newResponsabile(matricola, sede, tipo);
		
		iscriviti.dispose();
	}
	
	
	public void removeResponsabile(String sede, String tipo) {
		
		laboratorioDAO.rimuoviResponsabile(sede, tipo);
		
		iscriviti.dispose();
	}
	
	public String currentMatricolaSession() {
		
		return currentSession.getUserMatricola();
	}
	
	
	public Boolean alreadyResponsabile() {
		
		String matricola = currentSession.getUserMatricola();
		
		Vector<String> responsabili = laboratorioDAO.allResponsabili();
		
		if(responsabili.isEmpty()) {
			
			return false;
			
		} else if(responsabili.contains(matricola)) {
			
			return true;
			
		} else { return false; }
	}
	
	
////////////////////////////////////// GESTIONE POSTAZIONI //////////////////////////////////////
	
	
	public Integer sedeResponsabile() {
		
		sedeDAO = new SedeDAO(this);
		
		Integer sedeR = sedeDAO.sedeScelta(currentSession.getUserMatricola());
		
		return sedeR;
	}
	
	
	public String labResponsabile() {
		
		laboratorioDAO = new LaboratorioDAO(this);
		
		String labR = laboratorioDAO.tipoLaboratorioScelto(currentSession.getUserMatricola());
		
		return labR;
	}
	
	
	public void openNuovaPostazionePage() {
		
		Integer sede = this.sedeResponsabile();
		String lab = this.labResponsabile();
		
		nuovaPostazione = new NuovaPostazione(this, lab, sede);
		nuovaPostazione.setLocationRelativeTo(mainWindow);
		nuovaPostazione.setVisible(true);
	}
	
	
	public void createNewPostazione(String lab, Integer sede, Integer maxStrumenti) {
		
		currentPostazione = new Postazione(this);
		
		currentPostazione.setLaboratorioAppartenenza(lab);
		currentPostazione.setSedeAppartenenza(sede);
		currentPostazione.setMaxStrumenti(maxStrumenti);
		
		postazioneDAO = new PostazioneDAO(this);
		postazioneDAO.newPostazione(currentPostazione);
		
		nuovaPostazione.dispose();
	}
	
	
	public Vector<Integer> getAllPostazioniResponsabile(){
		
		postazioneDAO = new PostazioneDAO(this);
		Vector<Integer> postazioni = postazioneDAO.getAllPostazioniAssociate(currentSession.getUserMatricola());
		
		return postazioni;
	}
	
	public void GotoSceltaSede() {
		
		sedeDAO = new SedeDAO(this);
		Vector<String> allSedi = sedeDAO.allNomiSedi();
		
		scegliSede = new ScegliSede(this, allSedi);
		scegliSede.setVisible(true);
		scegliSede.setLocationRelativeTo(mainWindow);
	}
	
	
////////////////////////////////////// GESTIONE STRUMENTI //////////////////////////////////////
	
	
	public Boolean strumentoNotEmpty(AggiungiStrumento pageStrumento) {
		
		if(!pageStrumento.getTipoStrumento().equals("")) {
			if(!pageStrumento.getTempoMax().equals("")) {
				if(!pageStrumento.getDescrizione().equals("")) {
					
					return true;
					
				} else { return false; }
				
			} else { return false; }
			
		} else { return false; }
		
	}
	
	public void openAggiungiStrumento() {
		
		Vector<Integer> allPostazioni = this.getAllPostazioniResponsabile();
		
		if(!allPostazioni.isEmpty()) {
			
			aggiungiStrumento = new AggiungiStrumento(this, allPostazioni, labResponsabile());
			aggiungiStrumento.setLocationRelativeTo(mainWindow);
			aggiungiStrumento.setVisible(true);
			
		} else {
			
			nessunaPostazione = new NessunaPostazioneAssociata();
			nessunaPostazione.setLocationRelativeTo(mainWindow);
			nessunaPostazione.setVisible(true);
		}
	
	}
	
	
	public Strumento newStrumento() {
			
			strumentoTEMP = new Strumento(this);
			strumentoTEMP.setTipo(aggiungiStrumento.getTipoStrumento());
			strumentoTEMP.setMaxUtilizzo(aggiungiStrumento.getTempoMax());
			strumentoTEMP.setPostazioneAssegnata(aggiungiStrumento.getPostazioneAssegnata());
			strumentoTEMP.setDescrizione(aggiungiStrumento.getDescrizione());

		return strumentoTEMP;
	}
	
	
	public void aggiungiStrumento() {
		
		strumentoDAO = new StrumentoDAO(this);
		
		if(this.strumentoNotEmpty(aggiungiStrumento)) {
			
			if(!strumentoDAO.newStrumento(this.newStrumento())) {
				
				aggiungiStrumento.dispose();
				
			} else {
				
				aggiungiStrumento.errorMessage1.setVisible(true);
				aggiungiStrumento.errorMessage2.setVisible(false);
			}
			
		} else { 
			
			aggiungiStrumento.errorMessage1.setVisible(false);
			aggiungiStrumento.errorMessage2.setVisible(true);
		}
	}
	
////////////////////////////////////// GO TO PAGES //////////////////////////////////////
	
	public void GotoLoginPage(JFrame currentPage) {
	
		loginWindow = new LoginWindow(this);
		loginWindow.setUndecorated(true);
		loginWindow.setVisible(true);
	
		currentPage.dispose();
	}
	
	public void GotoRegisterPage(JFrame fromLogin) {
	
		registerWindow = new RegisterWindow(this);
		registerWindow.setUndecorated(true);
		registerWindow.setVisible(true);
		
		fromLogin.dispose();
	}
	
	public void GotoPasswordRecoveryPage(JFrame fromLogin) {
	
		passwordRecoveryWindow = new PasswordRecoveryWindow(this);
		passwordRecoveryWindow.setUndecorated(true);
		passwordRecoveryWindow.setVisible(true);
		
		fromLogin.dispose();
	}
	
	public void ReturnAfterRegistration(JFrame currentWindow) {
	
		currentWindow.dispose();
		loginWindow = new LoginWindow(this);
		loginWindow.setUndecorated(true);
		loginWindow.setVisible(true);
		
		toLoginDialog.dispose();
	}
	
////////////////////////////////////// CHECK INFORMATION LENGTH //////////////////////////////////////
	
	public Boolean CheckCFLength(String CFInserted) {
		
		if(CFInserted.length() == 16) {
			return true;
			
		} else return false;
	}
	
	public Boolean CheckPasswordLength(String passwordInserted) {
		
		if(passwordInserted.length() > 7 && passwordInserted.length() < 17) {
			return true;
			
		} else return false;
		
	}
	
	
////////////////////////////////////// CHECK MISSING INFO //////////////////////////////////////
	
	public Boolean CheckMissingLoginInfo(LoginPanel login) {
		
		//Checking if the fields are empty
		if(!login.getMatricolaLogin().equals("") && !login.getPasswordLogin().equals("")) {
			
			return true;
			
		} else { return false; }
	}
	
	
	public Boolean CheckMissingRecoveryInfo(PasswordRecoveryPanel recovery) {
		
		//Checking if the fields are empty
		if(!recovery.getMatricolaInserted().equals("") && !recovery.getNewPasswordInserted().equals("")) {
			if(!recovery.getEmailInserted().equals("") && !recovery.getTelefonoInserted().equals("")) {
				if(!recovery.getCFInserted().equals("")) {
					
					return true;
					
				} else { return false; }
				
			} else { return false; }
			
		} else { return false; }
		
	} 
	
	
	public Boolean CheckMissingPersonalInfo(AnagraficaPanel anagrafica) {
		
		//Checking if the fields are empty
	    if(!anagrafica.getNomeInserted().equals("") && !anagrafica.getCognomeInserted().equals("")) {
	    	if(!anagrafica.getGiornoInserted().equals("GG") && !anagrafica.getMeseInserted().equals("MM") && !anagrafica.getAnnoInserted().equals("")) {
	    		if(!anagrafica.getCFInserted().equals("")) {
	    			if(!anagrafica.getTelefonoInserted().equals("") && !anagrafica.getEmailInserted().equals("")) {
	    					
		    				//no missing info
		    				return true;

	    			} else { return false; }
	    			
	    		} else { return false; }
	    		
	    	}else { return false; }
	    	
	    }else { return false; }
	}
	
	
////////////////////////////////////// REGISTRATION //////////////////////////////////////
	
	public Tecnico CreazioneTecnicoFinale(String matricola, CredenzialiPanel credenziali) {
		
		tecnico = new Tecnico(this);
		
		tecnico.setMatricola(matricola);
		tecnico.setPassword(credenziali.getPasswordInserted());
		tecnico.setNome(this.tecnicoTemp.getNome());
		tecnico.setCognome(this.tecnicoTemp.getCognome());
		tecnico.setDataNascita(this.tecnicoTemp.getDataNascita());
		tecnico.setSesso(this.tecnicoTemp.getSesso());
		tecnico.setCodiceFiscale(this.tecnicoTemp.getCodiceFiscale());
		tecnico.setTelefono(this.tecnicoTemp.getTelefono());
		tecnico.setEmail(this.tecnicoTemp.getEmail());
		
		return tecnico;
	}
	
	public void RegisterNewUser(String newMatricola, CredenzialiPanel currentCredenziali) {
		
		Tecnico tecnicoCreato = CreazioneTecnicoFinale(newMatricola, currentCredenziali);
		tecnicoDAO = new TecnicoDAO(this);
		tecnicoDAO.creaTecnico(tecnicoCreato);
	}
	
	public void EndRegistration(CredenzialiPanel credenziali) {
		
		if(CheckPasswordLength(credenziali.getPasswordInserted())) {
			
			RegisterNewUser(matricolaFinale, credenziali);
			toLoginDialog = new ReturnToLoginPage(this, "Registrazione completata!", registerWindow);
			toLoginDialog.setLocationRelativeTo(registerWindow);
			
		} else { credenziali.passwordBreve.setVisible(true); }

		
	}
	
	public String CreazioneNuovaMatricola() {
		
		tecnicoDAO = new TecnicoDAO(this);
		String matricolaCompleta;
		
		do {
			
			Random random = new Random();
			int value = random.nextInt(999999) + 1000000;
			
			matricolaCompleta = "LM" + String.valueOf(value);
			
		} while(tecnicoDAO.checkExistingMatricola(matricolaCompleta));
		
		return matricolaCompleta;
	}
	
	public void CreazioneTecnicoTemporanea(AnagraficaPanel anagrafica) {
		
		this.tecnicoTemp = new Tecnico(this);
		
		this.tecnicoTemp.setNome(anagrafica.getNomeInserted());
		this.tecnicoTemp.setCognome(anagrafica.getCognomeInserted());
		this.tecnicoTemp.setDataNascita(anagrafica.getDataNascitaInserted());
		this.tecnicoTemp.setSesso(anagrafica.getSessoInserted());
		this.tecnicoTemp.setCodiceFiscale(anagrafica.getCFInserted());
		this.tecnicoTemp.setTelefono(anagrafica.getTelefonoInserted());
		this.tecnicoTemp.setEmail(anagrafica.getEmailInserted());

	}
	
	public void LastRegistrationPageOpened(AnagraficaPanel anagrafica, CredenzialiPanel credenziali) {
		
		matricolaFinale = CreazioneNuovaMatricola();
		credenziali.setMatricolaToShow(matricolaFinale);
		credenziali.setVisible(true);
		anagrafica.setVisible(false);
		
	}
	
	
	public void GoAheadWithRegistration(AnagraficaPanel anagrafica, CredenzialiPanel credenziali) {
		
		if(CheckMissingPersonalInfo(anagrafica)) {
			
			CreazioneTecnicoTemporanea(anagrafica);
			LastRegistrationPageOpened(anagrafica, credenziali);
			
		} else { anagrafica.datiErratiMancanti.setVisible(true); }
		
	}
	
////////////////////////////////////// LOGIN //////////////////////////////////////
	
	public Tecnico getTecnicoFromDB(String matricola) {
		
		tecnicoDAO = new TecnicoDAO(this);
		
		tecnico = tecnicoDAO.getSingoloTecnico(matricola);
		
		return tecnico;
		
	}
	
	public void ExecuteLogin(LoginPanel currentLogin) {
		
		tecnicoDAO = new TecnicoDAO(this);
		
		if(this.CheckMissingLoginInfo(currentLogin)) {
			
			if(tecnicoDAO.checkMatchingCredentials(currentLogin.getMatricolaLogin(), currentLogin.getPasswordLogin())) {
				
				tecnico = this.getTecnicoFromDB(currentLogin.getMatricolaLogin());
				currentSession = new Session(this, tecnico);
				
				loginWindow.dispose();
				
				mainWindow =  new MainWindow(this, currentSession);
				mainWindow.setVisible(true);
				
			} else { currentLogin.datiErratiMancanti.setVisible(true); }
			
		} else { currentLogin.datiErratiMancanti.setVisible(true); }

	}
	
////////////////////////////////////// RECOVERY //////////////////////////////////////
	
	public void RecoverInformations(PasswordRecoveryPanel currentRecovery) {
		
		if(CheckMissingRecoveryInfo(currentRecovery)) {
			
			tecnicoDAO = new TecnicoDAO(this);
			
			if(tecnicoDAO.checkCorrectRecoveryInfo(currentRecovery)) {
				
				if(tecnicoDAO.nuovaPassword(currentRecovery)) {
					
					toLoginDialog = new ReturnToLoginPage(this, "Password recuperata!", passwordRecoveryWindow);
					toLoginDialog.setLocationRelativeTo(registerWindow);
					
				} else { currentRecovery.datiErratiMancanti.setVisible(true); }
				
			} else { currentRecovery.datiErratiMancanti.setVisible(true); }
			
		} else { currentRecovery.datiErratiMancanti.setVisible(true); }
	}
	
	
	
////////////////////////////////////// GOTO PROGRAM FUNCTIONS //////////////////////////////////////
	
	public void GoToLaboratori(JPanel allPages[]) {
		
		for(int i = 0; i < 3; i ++) {
			allPages[i].setVisible(false);
		}
		
		//Setting true to Lab Panel
		allPages[0].setVisible(true);
	}
	
	public void GoToStrumenti(JPanel allPages[]) {
		
		for(int i = 0; i < 3; i ++) {
			allPages[i].setVisible(false);
		}
		
		//Setting true to Strumenti Panel
		allPages[1].setVisible(true);
	}
	
	public void GoToPrenotazioni(JPanel allPages[]) {
		
		for(int i = 0; i < 3; i ++) {
			allPages[i].setVisible(false);
		}
		
		//Setting true to Prenotazioni Panel
		allPages[2].setVisible(true);
	}
	
}