
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

	static final private String[] elencoComandi = {"vai", "cfu", "prendi", "posa","borsa", "fine","aiuto"};

	private Partita partita;

	private IOConsole io;


	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	

		do		
			istruzione = io.leggiRiga();
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
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("cfu"))
			this.cfu();
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("borsa"))
			this.stampaBorsa();
		else
			io.mostraMessaggio("Comando sconosciuto");

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

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di cfu.
	 * @param string 
	 */
	private void cfu() {
		io.mostraMessaggio("Hai " + this.partita.getGiocatore().getCfu()+" cfu");
	}

	/**
	 * Stampa informazioni di aiuto.
	 */

	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio("- "+elencoComandi[i]);
		io.mostraMessaggio("");
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			direzione = io.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
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
	
	private void stampaBorsa() {
		this.partita.getGiocatore().getBorsa().toString();
	}
	
	private void prendi(String attrezzo) {
		if(attrezzo==null) {
			io.mostraMessaggio("Quale attrezzo vuoi prendere ?");
			attrezzo = io.leggiRiga();
		}
		this.partita.getGiocatore().prendi(attrezzo);
	}
	
	private void posa(String attrezzo) {
		this.partita.getGiocatore().posa(attrezzo);
	}
	
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");
	}

	public static void main(String[] argc) {
		IOConsole io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}