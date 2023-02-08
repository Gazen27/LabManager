-- popolamento laboratoro
INSERT INTO laboratorio(tipo, descrizione) VALUES('Informatica', 'Sviluppo software, Cybersecurity, Studio di IA');
INSERT INTO laboratorio(tipo, descrizione) VALUES('Chimica', 'Chimica organica, Chimica inorganica, Studio dei reagenti');
INSERT INTO laboratorio(tipo, descrizione) VALUES('Biologia', 'Studio della cellula, Dissezione e analisi organiche');
INSERT INTO laboratorio(tipo, descrizione) VALUES('Astronomia', 'Analisi dei corpi celesti');
INSERT INTO laboratorio(tipo, descrizione) VALUES('Geologia', 'Studio di minerali, Vulcanologia, Fenomeni metereologici');
INSERT INTO laboratorio(tipo, descrizione) VALUES('Fisica', 'Dinamica, Termodinamica, Leggi del moto, Temperature');


-- popolamento sede
INSERT INTO sede(nome, indirizzo) VALUES('MSA', 'Via Vicinale Cupa Cintia, 26'); --1
INSERT INTO sede(nome, indirizzo) VALUES('VCL', 'Via Claudio, 21'); --2
INSERT INTO sede(nome, indirizzo) VALUES('PZT', 'Piazzale Vincenzio Tecchio, 80'); --3
INSERT INTO sede(nome, indirizzo) VALUES('GGC', 'Via Adriano, 83'); --4
INSERT INTO sede(nome, indirizzo) VALUES('DCJ', 'Via Cornelia dei Gracchi, 45'); --5
INSERT INTO sede(nome, indirizzo) VALUES('PRS', 'Via Canonico Scherillo, 18'); --6


-- popolamento locazione
INSERT INTO locazione(tlaboratorio, csede) VALUES('Informatica', 1);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Informatica', 2);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Informatica', 3);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Chimica', 3);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Chimica', 2);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Biologia', 1);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Biologia', 3);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Biologia', 4);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Astronomia', 2);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Astronomia', 3);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Informatica', 4);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Astronomia', 1);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Geologia', 2);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Geologia', 4);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Fisica', 5);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Fisica', 6);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Informatica', 6);
INSERT INTO locazione(tlaboratorio, csede) VALUES('Chimica', 5);


-- popolamento tecnico
INSERT INTO tecnico(matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email)
VALUES('LM1990401', 'GianniLab', 'Giovanni', 'Adamo', '2001-05-27', 'M', 'DMAGNN01E27F839H', '3469773472', 'gianni.adamo@hotmail.it');

INSERT INTO tecnico(matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email)
VALUES('LM1633608', 'Jacopixel33', 'Jacopo', 'de Leo', '2001-09-17', 'M', 'DLEJCP01P17F839X', '3921821391', 'jacopo.deleo@hotmail.it');

INSERT INTO tecnico(matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email)
VALUES('LM1493704', 'SteveGames88', 'Fabio', 'Sarà', '2001-11-04', 'M', 'SRAFBA01S04F839C', '3935397033', 'fabiosara@hotmail.it');

INSERT INTO tecnico(matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email)
VALUES('LM1391596', 'PassChaddone', 'Carlo', 'De Angelis', '2001-07-18', 'M', 'DNGCRL01L18F839A', '3421800844', 'carlodeangelis@hotmail.it');

INSERT INTO tecnico (matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email) 
VALUES ('LM1234567', 'passMarioR', 'Mario', 'Rossi', '1990-03-15', 'M', 'RSSMRA90A01H501Q', '1234567890', 'mario.rossi@email.com');

INSERT INTO tecnico (matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email) 
VALUES ('LM8765432', 'passLuciaB', 'Lucia', 'Bianchi', '1995-02-14', 'F', 'BNCLCU95B54G702A', '9876543210', 'lucia.bianchi@email.com');

INSERT INTO tecnico (matricola, pass, nome, cognome, datanascita, sesso, codicefiscale, telefono, email)
VALUES ('LM7842105', 'passDavide11', 'Davide', 'Crispano', '2001-06-07', 'M', 'CRSDVD01E07F839A', '3286543210', 'davide.crispano@gmail.com');


-- popolamento lavora
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1990401', 1, 'Informatica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1633608',3,'Chimica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1493704',1,'Biologia');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1633608',3,'Astronomia');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1391596',2,'Geologia');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1234567',5,'Fisica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM8765432',6,'Fisica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM7842105',4,'Geologia');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1391596',2,'Informatica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM8765432',4,'Informatica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM7842105',2,'Chimica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1990401',1,'Astronomia');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1633608',2,'Geologia');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1391596',3,'Biologia');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM7842105',6,'Informatica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM8765432',5,'Fisica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM1391596',5,'Chimica');
INSERT INTO lavora(matricolatecnico, codsede, tipo) VALUES('LM8765432',4,'Geologia');


-- popolamento postazione
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(1,'Informatica',1,2,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(2,'Chimica',3,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(3,'Biologia',1,2,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(4,'Atronomia',3,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(5,'Geologia',2,4,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(6,'Fisica',5,2,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(7,'Fisica',6,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(8,'Geologia',4,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(9,'Informatica',2,4,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(10,'Informatica',4,6,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(11,'Chimica',2,2,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(12,'Astronomia',1,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(13,'Geologia',2,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(14,'Biologia',3,4,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(15,'Informatica',6,2,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(16,'Fisica',5,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(17,'Chimica',5,3,0);
INSERT INTO postazione(codpostazione, laboratoriopostazione, sedepostazione, maxstrumenti, currentstrumenti) VALUES(18,'Geologia',4,4,0);


-- popolamento prenotazioni
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM1990401',1,1,'2023-02-03',2,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM1633608',2,9,'2023-03-24',1,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM1493704',3,10,'2023-04-23',1,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM1391596',4,15,'2023-06-20',2,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM1234567',5,2,'2023-08-18',3,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM8765432',6,11,'2023-11-08',2,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM7842105',7,17,'2023-12-05',1,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM8765432',8,3,'2023-05-03',1,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM1990401',9,14,'2023-08-21',2,false);
INSERT INTO prenotazioni(matricolaprenotata, strumentoprenotato, postazioneprenotata, dataprenotazione, oreprenotate, conclusa) VALUES('LM1990401',1,3,'2023-09-13',3,false);


-- popolamento strumento
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(1,'Computer Fisso','Computer marca DELL',2,1);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(2,'Stampante Laser','Stampante marca EPSON',3,9);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(3,'Plotter','Plotter marca HP',1,10);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(4,'MainFrame','MainFrame marca IBM',2,15);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(5,'Becco Bunsen','Marca Neolab',3,2);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(6,'Refrigeranti','Marca Allihn',4,11);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(7,'Beuta','Beuta Erlenmeyer collo largo',2,17);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(8,'Microscopio','Marca Digiteck',2,3);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(9,'Pallone','Pallone per colture cellulari',3,14);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(10,'Imbuto','Imbuto in plastica',4,3);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(11,'Vetrini','Vetrini per microscopio',2,14);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(12,'Kit dissezione','Marca Ronaldo',2,14);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(13,'Planetario','Planetario portatile SPLN',3,12);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(14,'Telescopio','Telescopio multi accessoriato',1,12);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(15,'Telescopio','Marca Taurus',2,12);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(16,'Bussola','Marca DQY',3,5);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(17,'Sismografo','Marca WitMotion',4,8);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(18,'Geofono sismico','Marca Set',1,13);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(19,'Dinamometro','Marca Sauter',3,7);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(20,'Peseria','Class certificata Accredia',4,6);
INSERT INTO strumento(codstrumento, tipo, descrizionestrumento, utilizzomax, postazioneassegnata) VALUES(21,'Torsiometro','Marca Metrica',1,16);


-- popolamento storico
-- (vuoto, viene inserito automaticamente tramite la procedure aggiorna_conclusa)
