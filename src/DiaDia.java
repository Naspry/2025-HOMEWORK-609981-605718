

import java.util.Scanner;

import it.uniroma3.diadia.IOConsole;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
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

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "cfu", "prendi", "posa"};

	private Partita partita;

	public static IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("cfu"))
			this.cfu();
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			this.io.mostraMessaggio("Comando sconosciuto");

		if (this.partita.isFinita()) {
			if (this.partita.isVinta() && this.partita.getGiocatore().getCfu()>0) {
				this.io.mostraMessaggio("Congratulazioni, sei in "+this.partita.getLabirinto().getStanzaCorrente().getNome());
				this.io.mostraMessaggio("hai vinto con "+this.partita.getGiocatore().getCfu()+" cfu");
			}
			else
				this.io.mostraMessaggio("Mi dispiace, hai finito i cfu e hai perso!");
			return true;
		}


		return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di cfu.
	 * @param string 
	 */
	private void cfu() {
		this.io.mostraMessaggio("Ti sono rimasti " + this.partita.getGiocatore().getCfu()+" cfu");
	}

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		this.io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			Scanner scannerDirezione = new Scanner(System.in);
			this.io.mostraMessaggio("Dove vuoi andare ?");
			direzione = scannerDirezione.nextLine();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			//diminuisci cfu per spostamento
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			cfu -= 1;
			this.partita.getGiocatore().setCfu(cfu);
			//se cambi stanza ma non sei in quella vincente stampa una desc.
			if(this.partita.getLabirinto().getStanzaCorrente()!=this.partita.getLabirinto().getStanzaFinale()) {
				io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
			}
		}

	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		io = new IOConsole();
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}