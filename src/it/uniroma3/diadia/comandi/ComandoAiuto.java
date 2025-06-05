package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComandoAiuto extends AbstractComando{
	
	
	public ComandoAiuto(IO io) {
		super.setIO(io);
	}
	
	static final private List<String> elencoComandi = new ArrayList<String>(Arrays.asList("vai, aiuto, fine, prendi, posa, borsa, guarda, mangia, regala, interagisci, saluta"));
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.size(); i++) 
			getIO().mostraMessaggio(elencoComandi.get(i)+" ");
		getIO().mostraMessaggio(" ");
	}
	
}
