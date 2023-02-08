-- tecnico
CREATE TABLE tecnico
(
    matricola varchar(9) PRIMARY KEY,
    pass varchar(16) UNIQUE,
    nome varchar(20) NOT NULL,
    cognome varchar(20) NOT NULL,
    datanascita date NOT NULL,
    sesso character(1) NOT NULL,
    codicefiscale varchar(16) UNIQUE,
    telefono varchar(10) UNIQUE,
    email varchar(30) UNIQUE,
	
	CONSTRAINT matricolaLength CHECK(char_length(matricola) = 9),
	CONSTRAINT passLength CHECK(char_length(pass) > 7),
	CONSTRAINT CFLength CHECK(char_length(codicefiscale) = 16)
);


-- laboratorio
CREATE TABLE laboratorio
(
	tipo varchar(20) PRIMARY KEY,
	descrizione text NOT NULL,
	numeroSedi integer DEFAULT 0
);


-- sede
CREATE TABLE sede
(
	codSede serial PRIMARY KEY,
	nome varchar(3) UNIQUE,
	indirizzo varchar(30) NOT NULL
);


-- lavora
CREATE TABLE lavora
(
	matricolaTecnico varchar(9) NOT NULL,
	codSede integer NOT NULL,
	tipo varchar(20) NOT NULL,
	
	CONSTRAINT matrTec FOREIGN KEY(matricolaTecnico) REFERENCES tecnico(matricola) ON DELETE CASCADE,
	CONSTRAINT codiceSede FOREIGN KEY(codSede) REFERENCES sede(codSede) ON DELETE CASCADE,
	CONSTRAINT tipoLaboratorio FOREIGN KEY(tipo) REFERENCES laboratorio(tipo) ON DELETE CASCADE
);


-- locazione
CREATE TABLE locazione
(
	TLaboratorio varchar(20) NOT NULL,
	Csede integer NOT NULL,
	numeroTecnici integer DEFAULT 0,
	numeroPostazioni integer DEFAULT 0,
	responsabile varchar(9) DEFAULT NULL,
	
	CONSTRAINT onLaboratorio FOREIGN KEY(TLaboratorio) REFERENCES laboratorio(tipo) ON DELETE CASCADE,
	CONSTRAINT onSede FOREIGN KEY(Csede) REFERENCES sede(codSede) ON DELETE CASCADE,
	CONSTRAINT matricolaResponsabile FOREIGN KEY(responsabile) REFERENCES tecnico(matricola) ON UPDATE CASCADE
);


-- postazione
CREATE TABLE postazione
(
	codPostazione serial PRIMARY KEY,
	laboratorioPostazione varchar(20) NOT NULL,
	sedePostazione integer NOT NULL,
	maxStrumenti integer NOT NULL,
	currentStrumenti integer NOT NULL DEFAULT 0,
	
	CONSTRAINT numeroStrumenti CHECK(currentStrumenti <= maxStrumenti)
);


-- strumento
CREATE TABLE strumento
(
	codStrumento serial PRIMARY KEY,
	tipo VARCHAR(20) NOT NULL,
	descrizioneStrumento text NOT NULL,
	utilizzoMax integer NOT NULL,
	postazioneAssegnata integer NOT NULL,
	
	CONSTRAINT postazioneStrumento FOREIGN KEY(postazioneAssegnata) REFERENCES postazione(codPostazione) ON DELETE CASCADE
);


-- storico
CREATE TABLE storico
(
	codicePrenotazione integer NOT NULL,
	strumentoStorico integer NOT NULL,
	utilizzatore VARCHAR(9) NOT NULL,
	dataStorico date NOT NULL,
	tempoUtilizzo integer NOT NULL,
	
	CONSTRAINT onStrumento FOREIGN KEY(strumentoStorico) REFERENCES strumento(codStrumento) ON DELETE CASCADE
);


-- prenotazioni
CREATE TABLE prenotazioni
(
	codicePrenotazione serial PRIMARY KEY,
	matricolaPrenotata varchar(9) NOT NULL,
	strumentoPrenotato integer NOT NULL,
	postazionePrenotata integer NOT NULL,
	dataPrenotazione date NOT NULL,
	orePrenotate integer NOT NULL,
	conclusa boolean DEFAULT false,
	
	CONSTRAINT onMatricola FOREIGN KEY(matricolaPrenotata) REFERENCES tecnico(matricola) ON DELETE CASCADE,
	CONSTRAINT onStrumentoPrenotato FOREIGN KEY(strumentoPrenotato) REFERENCES strumento(codStrumento) ON DELETE CASCADE
	
);
---------------------------------------------------------------


-- VIEW 1: postazione & locazione
CREATE VIEW postazioneLocazione
AS
(
SELECT pos.codpostazione,
    pos.laboratoriopostazione,
    pos.sedepostazione,
    u.nome
   FROM postazione pos
     JOIN ( SELECT l.tlaboratorio,
            l.csede,
            s.nome
           FROM locazione l
             JOIN sede s ON l.csede = s.codsede) u ON pos.laboratoriopostazione::text = u.tlaboratorio::text AND pos.sedepostazione = u.csede
);


-- VIEW 2: strumento & postazione
CREATE VIEW strumentoCompleto
AS
(
SELECT s.codstrumento,
    s.tipo,
    s.postazioneassegnata,
	s.utilizzoMax,
    cp.laboratoriopostazione,
    cp.nome
   FROM strumento s
     JOIN postazionelocazione cp ON s.postazioneassegnata = cp.codpostazione
);
---------------------------------------------------------------


-- TRIGGER AUMENTO DEL NUMERO DI SEDI
Create function numero_righe()  
returns trigger
language plpgsql
AS  
$$  
Declare  
risultato integer;
materia varchar(20); 
cur_righe cursor for select tipo  from laboratorio;
Begin  
	open cur_righe;
	loop
		fetch cur_righe into materia;
		exit when not found;
		select count(csede)
		into risultato
		from locazione
		where tlaboratorio=materia;

		update laboratorio set numerosedi= @risultato where tipo= materia;
	end loop;
	close cur_righe;	
	return NEW;
End;  
$$;  

CREATE TRIGGER aggiorna_numero_sedi
    AFTER INSERT ON locazione
    FOR EACH ROW
    EXECUTE function numero_righe();
	
	

-- TRIGGER AUMENTO DEL NUMERO DI TECNICI
Create function numero_tecnici() 
returns trigger
language plpgsql
AS  
$$  
Declare  
risultato integer;
materia varchar(20);
codice_sede integer;
cur_dati cursor for select csede,tlaboratorio from locazione;
Begin  
	open cur_dati;
	risultato:=0;
	loop
	
		fetch cur_dati into codice_sede,materia;
		exit when not found;		
		
		select count(lavora.matricolatecnico)
		into risultato
		from lavora
	    right join sede on lavora.codsede=sede.codSede
		right join tecnico on lavora.matricolatecnico=tecnico.matricola
		where lavora.codsede=codice_sede and lavora.tipo=materia;
		
		update locazione set numerotecnici=risultato where csede=codice_sede and tlaboratorio=materia;
	end loop;
	close cur_dati;
	return NEW;
End;  
$$;  

CREATE TRIGGER aggiorna_numero_tecnici
    AFTER INSERT OR DELETE ON lavora
    FOR EACH ROW
    EXECUTE function numero_tecnici();
	
	
	
-- TRIGGER AUMENTO DEL NUMERO DI POSTAZIONI
Create function numero_postazioni()  
returns trigger
language plpgsql
AS  
$$  
Declare  
 codice_laboratorio varchar(20);
 codic_sede integer;
 risultato integer; 
 cur_dati cursor for select tlaboratorio,csede from locazione;
Begin  
	open cur_dati;
	loop
		fetch cur_dati into codice_laboratorio,codic_sede;
		exit when not found;
		
		select count(codpostazione)
		into risultato
		from postazione
		right join locazione 
		on locazione.tlaboratorio=postazione.laboratoriopostazione and locazione.csede=postazione.sedepostazione
		where locazione.tlaboratorio=codice_laboratorio and locazione.csede=codic_sede;
		
		update locazione set numeropostazioni=risultato where tlaboratorio=codice_laboratorio and csede=codic_sede;
		
	end loop;
	close cur_dati;
	return NEW;
End;  
$$; 

CREATE TRIGGER aggiorna_numero_postazioni
    AFTER INSERT OR DELETE ON postazione
    FOR EACH ROW
    EXECUTE function numero_postazioni();
	
	

-- TRIGGER AUMENTO DEL NUMERO DI STRUMENTI
Create function check_num_strumenti()  
returns trigger
language plpgsql
AS  
$$  
Declare  
cur_max_numero_strumenti cursor for select codpostazione,maxstrumenti from postazione;
numero_max integer;
codice integer;
risultato integer;
eccesso integer;
BEGIN
	open cur_max_numero_strumenti;
	LOOP
		FETCH cur_max_numero_strumenti into codice,numero_max;
		EXIT WHEN NOT FOUND;

		SELECT COUNT(codstrumento)
		INTO risultato
		FROM strumento
		RIGHT JOIN postazione ON postazione.codpostazione=strumento.postazioneassegnata
		WHERE postazioneassegnata=codice;

		IF risultato<=numero_max THEN
			UPDATE postazione SET currentstrumenti=risultato where codpostazione=codice;
		ELSE	
			
			SELECT  LAST_VALUE(codstrumento) 
				OVER(ORDER BY postazioneassegnata RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) ultimostrumento
			into eccesso
			FROM strumento
			where postazioneassegnata=codice LIMIT 1;

			delete from strumento where codstrumento=eccesso;
			
		END IF;
		
	END LOOP;
	close cur_max_numero_strumenti;
	return NEW;
End;  
$$; 

CREATE TRIGGER aggiorna_numero_strumenti
    AFTER INSERT OR DELETE ON strumento
    FOR EACH ROW
    EXECUTE function check_num_strumenti();
	
	

-- TRIGGER SUL CONTROLLO DATA DISPONIBILE
Create function check_prenotazione() 
returns trigger
language plpgsql
AS  
$$  
Declare  
DECLARE
caso BOOLEAN;
BEGIN
	select case when not exists
	(
		select strumentoprenotato,postazioneprenotata,dataprenotazione
		from prenotazioni where
		strumentoprenotato=NEW.strumentoprenotato and postazioneprenotata=NEW.postazioneprenotata and
		dataprenotazione=NEW.dataprenotazione
	)
	THEN TRUE 
	ELSE FALSE 
	into caso
	END;
	
	IF caso=FALSE THEN
		delete from prenotazioni where strumentoprenotato=NEW.strumentoprenotato and postazioneprenotata=NEW.postazioneprenotata and
		dataprenotazione=NEW.dataprenotazione;
		raise EXCEPTION 'strumento già prenotato in quella data!';
	END IF;

	
	return NEW;
End;  
$$;  

CREATE TRIGGER check_prenotazione_esistente
    BEFORE INSERT ON prenotazioni
    FOR EACH ROW
    EXECUTE function check_prenotazione();
	
	
	
-- TRIGGER SUL CONTROLLO DELL ORE PRENOTATE
Create function controllo_ore() 
returns trigger
language plpgsql
AS  
$$  
DECLARE
cursore_prenotazioni_strumento cursor for 
	select prenotazioni.strumentoprenotato,prenotazioni.oreprenotate,strumento.utilizzoMax 
	from prenotazioni,strumento 
	where prenotazioni.strumentoprenotato=strumento.codstrumento;

codice_struemento integer;
orario1 integer;
orario2 integer;

BEGIN
	open cursore_prenotazioni_strumento;

	loop
		fetch cursore_prenotazioni_strumento into codice_struemento,orario1,orario2;
		exit when not found;
		
		IF orario1>orario2 THEN
			delete from prenotazioni where strumentoprenotato= codice_struemento and oreprenotate= orario1;
		end if;
		
	end loop;
	
	close cursore_prenotazioni_strumento;

	return NEW;
End;  
$$;  

CREATE TRIGGER check_ore_utilizzo
    AFTER INSERT ON prenotazioni
    FOR EACH ROW
    EXECUTE function controllo_ore();



-- TRIGGER PASSAGGIO DA PRENOTAZIONE A STORICO
Create function passaggio_dati() 
returns trigger
language plpgsql
AS  
$$  
DECLARE
codiceprenotato integer;
codicestrumento integer;
utente_tecnico varchar(9);
data_storico date;
tempo_utilizzo integer;

cur_righe cursor FOR
SELECT prenotazioni.codiceprenotazione, prenotazioni.matricolaprenotata, prenotazioni.strumentoprenotato,
	   prenotazioni.dataprenotazione,prenotazioni.oreprenotate FROM prenotazioni WHERE prenotazioni.conclusa=TRUE;

BEGIN
	OPEN cur_righe;
	LOOP
		FETCH cur_righe into codiceprenotato,utente_tecnico,codicestrumento, data_storico, tempo_utilizzo;
		EXIT WHEN NOT FOUND;
		INSERT INTO storico (codiceprenotazione,utilizzatore,strumentostorico,datastorico,tempoutilizzo) 
		VALUES(codiceprenotato,utente_tecnico,codicestrumento, data_storico, tempo_utilizzo);

	END LOOP;
	CLOSE cur_righe;
	DELETE FROM prenotazioni where conclusa=TRUE;
	return NEW;
END;  
$$;  

CREATE TRIGGER salvataggio_dati_su_storico
    AFTER INSERT OR UPDATE ON prenotazioni
    FOR EACH ROW
    EXECUTE function passaggio_dati();
	
---------------------------------------------------------------
	
	
-- PROCEDURE TEMPO TRASCORSO
CREATE PROCEDURE AGGIORNA_CONCLUSA()
LANGUAGE PLPGSQL
AS $$
DECLARE 
righe_prenotazioni cursor for select codiceprenotazione,dataprenotazione from prenotazioni;
data_odierna date;

codiceprenota integer;
data_prenotata DATE;
BEGIN
	SELECT CAST(NOW()::timestamp AS DATE) INTO data_odierna;
	OPEN righe_prenotazioni;
	LOOP
		FETCH righe_prenotazioni into codiceprenota,data_prenotata;
		EXIT WHEN NOT FOUND;
		
		IF data_prenotata<data_odierna THEN
		UPDATE prenotazioni SET conclusa=TRUE WHERE codiceprenotazione=codiceprenota;
		END IF;
		
	END LOOP;
	CLOSE righe_prenotazioni;
	COMMIT;
END;
$$;

---------------------------------------------------------------
