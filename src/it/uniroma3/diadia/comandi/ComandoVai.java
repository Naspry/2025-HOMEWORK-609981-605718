package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IOConsole io;
	
	public ComandoVai(IOConsole io) {
		this.io = io;
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();	
		Stanza prossimaStanza = null;
		if(this.direzione == null) {
			io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if(prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu-1);		// diminuisci cfu per spostamento
		

	}
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro; 
	}


}
