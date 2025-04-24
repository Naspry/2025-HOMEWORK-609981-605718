package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	private IO io;
	
	public ComandoAiuto(IO io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Lista comandi: [aiuto, fine, vai, prendi, posa, guarda, borsa]");
		
	}

	@Override
	public void setParametro(String parametro) {
		
	}
	
}
