package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	private Direzione direzione;
	
	public ComandoVai(IO io) {
		setIO(io);
	}
	
	@Override
	public void esegui(Partita partita) {
	    String nomeDirezione = getParametro();
	    if (nomeDirezione == null) {
	        getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione.");
	        return;
	    }

	    Direzione direzione;
	    try {
	        direzione = Direzione.valueOf(nomeDirezione.toUpperCase());
	    } catch (IllegalArgumentException e) {
	        getIO().mostraMessaggio("Direzione inesistente.");
	        return;
	    }

	    Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
	    Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
	    
	    if (prossimaStanza == null) {
	        getIO().mostraMessaggio("Non puoi andare in quella direzione.");
	        return;
	    }

	    partita.getLabirinto().setStanzaCorrente(prossimaStanza);
	    getIO().mostraMessaggio(prossimaStanza.getDescrizione());

	    int cfu = partita.getGiocatore().getCfu();
	    partita.getGiocatore().setCfu(cfu - 1);
	}


}
