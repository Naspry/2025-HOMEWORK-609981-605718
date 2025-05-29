package it.uniroma3.diadia.personaggi;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{

	final static private String MSG_BUONO = "che culo";
	final static private String MSG_CATTIVO = "ti ha detto male";

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String interagisci(Partita p) {

		if(super.haSalutato() == true) {
			//trova stanza con maggior numero di item vicino a lui
			Set<String> dir = p.getStanzaCorrente().getDirezioni();
			if(dir.size() == 1) {  //se solo 1 stanza adiacente (dead-end)
				Iterator<String> it = dir.iterator();
				p.getLabirinto().setStanzaCorrente(p.getStanzaCorrente().getStanzaAdiacente(it.next()));
				return MSG_BUONO;
			}
			int max = -1;
			String dirMax = null;
			List<Attrezzo> att;
			for(String d: dir) {
				att = p.getStanzaCorrente().getStanzaAdiacente(d).getAttrezzi();
				if(att.size() > max) { 
					max = att.size();
					dirMax = d;
				}
			}

			//teletrasporta personaggio in stanza in dirMax
			p.getLabirinto().setStanzaCorrente(p.getStanzaCorrente().getStanzaAdiacente(dirMax));
			return MSG_BUONO;
		}else {
			Set<String> dir = p.getStanzaCorrente().getDirezioni();
			Iterator<String> it = dir.iterator();
			if(dir.size() == 1) {  //se solo 1 stanza adiacente (dead-end)
				p.getLabirinto().setStanzaCorrente(p.getStanzaCorrente().getStanzaAdiacente(it.next()));
				return MSG_BUONO;
			}

			int min = Integer.MAX_VALUE;
			String dirMin = null;
			for(String d : dir) {
				int numAtt = p.getStanzaCorrente().getStanzaAdiacente(d).getNumeroAttrezzi();
				if(numAtt < min) {
					min = numAtt;
					dirMin = d;
				}
			}

			//teletrasporta personaggio in stanza in dirMin
			p.getLabirinto().setStanzaCorrente(p.getStanzaCorrente().getStanzaAdiacente(dirMin));
			return MSG_CATTIVO;
		}

	}
}
