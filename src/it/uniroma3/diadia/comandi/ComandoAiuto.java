package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import java.lang.reflect.*;

public class ComandoAiuto extends AbstractComando{
	
	
	public ComandoAiuto(IO io) {
		super.setIO(io);
	}
	
	@Override
	public void esegui(Partita partita) {
		getIO().mostraMessaggio("Lista comandi: [aiuto, fine, vai, prendi, posa, guarda, borsa, regala]");
	
	}
	
}
