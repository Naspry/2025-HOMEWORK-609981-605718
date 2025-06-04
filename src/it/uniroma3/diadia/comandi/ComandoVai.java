package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	private String direzione;
	
	public ComandoVai(IO io) {
		setIO(io);
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();	
		Stanza prossimaStanza = null;
		this.direzione = getParametro();
		if(this.direzione == null) {
			getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if(prossimaStanza == null) {
			getIO().mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		getIO().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu-1);		// diminuisci cfu per spostamento
		

	}

}
