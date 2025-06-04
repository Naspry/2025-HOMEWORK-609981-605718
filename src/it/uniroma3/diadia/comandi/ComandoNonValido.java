package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{

	public ComandoNonValido(IO io) {
		setIO(io);
	}
	
	@Override
	public void esegui(Partita partita) {
		getIO().mostraMessaggio("Comando non valido");
	}
	
}
