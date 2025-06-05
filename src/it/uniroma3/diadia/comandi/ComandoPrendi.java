package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	
	String attrezzoDaPrendere;

	public ComandoPrendi(IO io) {
		setIO(io);
	}
	@Override
	public void esegui(Partita partita) {
		String attrezzoDaPrendere = getParametro();
		if(attrezzoDaPrendere == null) {
			getIO().mostraMessaggio("Cosa vuoi prendere? Devi specificare l'attrezzo");
			return;
		}
		if(!partita.getGiocatore().getBorsa().isFull()) {		//se la borsa non è piena
			Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente(); 
			Attrezzo att = stanzaCorrente.getAttrezzo(attrezzoDaPrendere);
			if(stanzaCorrente.hasAttrezzo(attrezzoDaPrendere)) {
				if(partita.getGiocatore().getBorsa().getPeso() + att.getPeso() <=partita.getGiocatore().getBorsa().getPesoMax()) {
					partita.getGiocatore().getBorsa().addAttrezzo(att);
					getIO().mostraMessaggio("Hai aggiunto "+ attrezzoDaPrendere +" alla borsa");
					stanzaCorrente.removeAttrezzo(att);
				}else getIO().mostraMessaggio(attrezzoDaPrendere + " pesa troppo");
			}else getIO().mostraMessaggio(attrezzoDaPrendere + " non presente");
		}else getIO().mostraMessaggio("La borsa è piena");
		return;
	}

}
