package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoBorsa implements Comando {
	private IO io;
	
	public ComandoBorsa(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		return;
	}

	@Override
	public void setParametro(String parametro) {
		

	}

}
