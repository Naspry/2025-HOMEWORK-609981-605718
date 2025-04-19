package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private IOConsole io;
	String attrezzoDaPrendere;

	public ComandoPrendi(IOConsole io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		if(attrezzoDaPrendere == null) {
			io.mostraMessaggio("Cosa vuoi prendere? Devi specificare l'attrezzo");
			return;
		}
		if(!partita.getGiocatore().getBorsa().isFull()) {		//se la borsa non è piena
			Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente(); 
			Attrezzo att = stanzaCorrente.getAttrezzo(attrezzoDaPrendere);
			if(stanzaCorrente.hasAttrezzo(attrezzoDaPrendere)) {
				if(partita.getGiocatore().getBorsa().getPeso() + att.getPeso() <=partita.getGiocatore().getBorsa().getPesoMax()) {
					partita.getGiocatore().getBorsa().addAttrezzo(att);
					io.mostraMessaggio("Hai aggiunto "+ attrezzoDaPrendere +" alla borsa");
					stanzaCorrente.removeAttrezzo(att);
				}else io.mostraMessaggio(attrezzoDaPrendere + " pesa troppo");
			}else io.mostraMessaggio(attrezzoDaPrendere + " non presente");
		}else io.mostraMessaggio("La borsa è piena");
		return;
	}




	@Override
	public void setParametro(String parametro) {
		this.attrezzoDaPrendere = parametro;

	}

}
