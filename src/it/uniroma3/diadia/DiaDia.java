package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

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
			    .addStanzaIniziale("Ingresso")
			    .addAttrezzo("Ingresso", "lanterna", 1)

			    .addStanza("Corridoio")
			    .addAttrezzo("Corridoio", "chiave", 1)

			    .addStanzaBuia("Cantina", "lanterna")
			    .addAttrezzo("Cantina", "scopa", 2)

			    .addStanzaMagica("Laboratorio")
			    .addAttrezzo("Laboratorio", "pozione", 1)

			    .addStanzaBloccata("PortoneNord", "chiave", Direzione.NORD)

			    .addStanza("Giardino")
			    .addAttrezzo("Giardino", "osso", 1)

			    .addStanza("Cameretta")
			    .addAttrezzo("Cameretta", "cuscino", 1)

			    .addStanza("Cucina")
			    .addAttrezzo("Cucina", "coltello", 2)

			    .addStanzaMagica("SalaAlchimia")
			    .addAttrezzo("SalaAlchimia", "elisir", 1)

			    .addStanzaBuia("Soffitta", "lanterna")

			    .addStanza("Atrio")

			    .addStanzaBloccata("PortaSegreta", "pozione", Direzione.EST)

			    .addStanza("SalaTrono")

			    .addStanzaVincente("Tesoro")

			    // Collegamenti
			    .addAdiacenza("Ingresso", "Corridoio", Direzione.NORD)
			    .addAdiacenza("Corridoio", "Cantina", Direzione.EST)
			    .addAdiacenza("Corridoio", "Laboratorio", Direzione.NORD)
			    .addAdiacenza("Laboratorio", "PortoneNord", Direzione.NORD)
			    .addAdiacenza("PortoneNord", "Giardino", Direzione.NORD)
			    .addAdiacenza("Giardino", "Cameretta", Direzione.EST)
			    .addAdiacenza("Cameretta", "Cucina", Direzione.SUD)
			    .addAdiacenza("Cucina", "SalaAlchimia", Direzione.EST)
			    .addAdiacenza("SalaAlchimia", "Soffitta", Direzione.NORD)
			    .addAdiacenza("Soffitta", "Atrio", Direzione.OVEST)
			    .addAdiacenza("Atrio", "PortaSegreta", Direzione.OVEST)
			    .addAdiacenza("PortaSegreta", "SalaTrono", Direzione.EST)
			    .addAdiacenza("SalaTrono", "Tesoro", Direzione.NORD)

			    // Personaggi (usando il nuovo metodo)
			    .addPersonaggioA("Cameretta", new Cane("Fido", "Guaisce felice"))
			    .addPersonaggioA("Laboratorio", new Mago("Merlino", "Parla con voce cavernosa", new Attrezzo("bacchetta", 1)))
			    .addPersonaggioA("Soffitta", new Strega("Morgana", "Ride misteriosamente"))

			    .getLabirinto();


				DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
	}

	public Partita getPartita() {
		return partita;
	}
}