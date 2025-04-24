package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	private IO io;
	String attrezzoDaPosare;
	
	public ComandoPosa(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		if(attrezzoDaPosare == null) {
			io.mostraMessaggio("Cosa vuoi posare? Devi specificare l'attrezzo");
			return;
		}
		if(!partita.getLabirinto().getStanzaCorrente().isFull()) {		//se la stanza non è piena
			Borsa borsaGiocatore = partita.getGiocatore().getBorsa();
			Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
			if(borsaGiocatore.hasAttrezzo(attrezzoDaPosare)) {
				Attrezzo att = borsaGiocatore.getAttrezzo(attrezzoDaPosare);
				stanzaCorrente.addAttrezzo(att);
				io.mostraMessaggio("Hai posato "+ attrezzoDaPosare +" in "+ stanzaCorrente.getNome());
				borsaGiocatore.removeAttrezzo(att);

			}else io.mostraMessaggio(attrezzoDaPosare + " non presente");
		}else io.mostraMessaggio("La stanza è piena");
		return;
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzoDaPosare = parametro;

	}

}
