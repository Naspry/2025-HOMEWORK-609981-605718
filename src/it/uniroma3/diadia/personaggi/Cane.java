package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio {

	private static final String MESSAGGIO_MORSO = "Woof.. (Morso)";
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String interagisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		return MESSAGGIO_MORSO;
	}

}
