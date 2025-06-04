package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoBorsa extends AbstractComando {
	
	public ComandoBorsa(IO io) {
		super.setIO(io);
	}
	@Override
	public void esegui(Partita partita) {
		getIO().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		return;
	}

	

}
