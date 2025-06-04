package it.uniroma3.diadia.personaggi;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

    final static private String MSG_BUONO = "che culo";
    final static private String MSG_CATTIVO = "ti ha detto male";

    public Strega(String nome, String presentaz) {
        super(nome, presentaz);
    }

    @Override
    public String interagisci(Partita p) {
        Set<String> direzioni = p.getStanzaCorrente().getDirezioni();

        if (direzioni.isEmpty())
            return "Nessuna stanza adiacente.";

        String direzioneTarget = null;

        if (this.haSalutato()) {
            // Cerca la stanza adiacente con più attrezzi
            int maxAttrezzi = -1;
            for (String dir : direzioni) {
                int numAttrezzi = p.getStanzaCorrente().getStanzaAdiacente(dir).getAttrezzi().size();
                if (numAttrezzi > maxAttrezzi) {
                    maxAttrezzi = numAttrezzi;
                    direzioneTarget = dir;
                }
            }
            p.getLabirinto().setStanzaCorrente(p.getStanzaCorrente().getStanzaAdiacente(direzioneTarget));
            return MSG_BUONO;
        } else {
            // Cerca la stanza adiacente con meno attrezzi
            int minAttrezzi = Integer.MAX_VALUE;
            for (String dir : direzioni) {
                int numAttrezzi = p.getStanzaCorrente().getStanzaAdiacente(dir).getAttrezzi().size();
                if (numAttrezzi < minAttrezzi) {
                    minAttrezzi = numAttrezzi;
                    direzioneTarget = dir;
                }
            }
            p.getLabirinto().setStanzaCorrente(p.getStanzaCorrente().getStanzaAdiacente(direzioneTarget));
            return MSG_CATTIVO;
        }
    }


	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
		saluta();
		Attrezzo att = new Attrezzo("Wand", 20);
		interagisci(partita);
		return null;
	}
}
