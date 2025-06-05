package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {
	

	public ComandoPosa(IO io) {
		super.setIO(io);
	}

	@Override
	public void esegui(Partita partita) {
		String attrezzoDaPosare = getParametro();  // usa parametro ereditato

		if(attrezzoDaPosare == null) {
			getIO().mostraMessaggio("Cosa vuoi posare? Devi specificare l'attrezzo");
			return;
		}
		
		Borsa borsaGiocatore = partita.getGiocatore().getBorsa();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		
		if(stanzaCorrente.isFull()) {
			getIO().mostraMessaggio("La stanza è piena");
			return;
		}
		
		if(borsaGiocatore.hasAttrezzo(attrezzoDaPosare)) {
			Attrezzo att = borsaGiocatore.getAttrezzo(attrezzoDaPosare);
			stanzaCorrente.addAttrezzo(att);
			getIO().mostraMessaggio("Hai posato " + attrezzoDaPosare + " in " + stanzaCorrente.getNome());
			borsaGiocatore.removeAttrezzo(att);
		} else {
			getIO().mostraMessaggio(attrezzoDaPosare + " non è presente nella borsa.");
		}
	}
}
