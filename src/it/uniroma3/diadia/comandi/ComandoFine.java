package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	
	public ComandoFine(IO io) {
		setIO(io);
	}
	@Override
	public void esegui(Partita partita) {
		getIO().mostraMessaggio("La partita è finita");
		partita.setFinita();

	}


}
