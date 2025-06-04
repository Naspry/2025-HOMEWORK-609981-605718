package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class FakePersonaggio extends AbstractPersonaggio {

	public FakePersonaggio(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String interagisci(Partita partita) {
		return "done";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		return null;
	}

}
