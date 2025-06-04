package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	private IO io;
	
	public ComandoGuarda(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Possiedi " + partita.getGiocatore().getCfu() + " cfu");
		return;
	}

}
