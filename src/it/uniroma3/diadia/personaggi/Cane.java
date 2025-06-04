package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private Attrezzo item;
	private static final String MESSAGGIO_MORSO = "Woof.. (Morso)";
	private static final String REGALO_BENE = "woooooOOOOOOOOooooof";
	private static final String REGALO_MALE = "WOOOOFF (NOT OSSO)";
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
		this.item = new Attrezzo("Pokeball", 8);
	}

	@Override
	public String interagisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		return MESSAGGIO_MORSO;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getStanzaCorrente().addAttrezzo(item);
		if(attrezzo.getNome().equals("osso") && item != null) {
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
			item = null;
			return REGALO_BENE;
		}
		return REGALO_MALE;
	}

}
