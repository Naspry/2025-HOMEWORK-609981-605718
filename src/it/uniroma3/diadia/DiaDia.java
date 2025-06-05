package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private Partita partita;
	private IO io;
	

	public DiaDia(Labirinto labirinto, IO io) {
		this.partita = new Partita(io);
		this.partita.setLabirinto(labirinto);
		this.io = io;
	}

	public void gioca() {
	    String istruzione;
	    io.mostraMessaggio(MESSAGGIO_BENVENUTO);

	    do {
	        istruzione = io.leggiRiga();
	        if (istruzione == null) {
	            
	            break;
	        }
	    } while (!processaIstruzione(istruzione));
	}



	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = null;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica(io);

		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (comandoDaEseguire != null) {
			comandoDaEseguire.esegui(this.partita);
		} else {
			io.mostraMessaggio("Comando non riconosciuto.");
		}

		if (this.partita.isFinita()) {
			if (this.partita.isVinta() && this.partita.getGiocatore().getCfu()>0) {
				io.mostraMessaggio("Congratulazioni, sei in "+this.partita.getLabirinto().getStanzaCorrente().getNome());
				io.mostraMessaggio("hai vinto con "+this.partita.getGiocatore().getCfu()+" cfu");
			}
			else
				io.mostraMessaggio("Mi dispiace, hai finito i cfu e hai perso!");
			return true;
		}
		return false;
	}   


	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addStanza("N12")
				.addAdiacenza("LabCampusOne","N12",Direzione.EST)
				.addAdiacenza("LabCampusOne","Biblioteca",Direzione.OVEST)
				.getLabirinto();
				DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
	}

	public Partita getPartita() {
		return partita;
	}
}