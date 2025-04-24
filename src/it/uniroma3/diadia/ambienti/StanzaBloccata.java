package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	String direzioneBloccata;
	String attrezzoRichiesto;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoRichiesto) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoRichiesto  = attrezzoRichiesto;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) {

		if(this.hasAttrezzo(attrezzoRichiesto)) 
			return super.getStanzaAdiacente(dir);
		else
			return this;

	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nUscite: ");
		for (String direzione : this.getDirezioni())
			if (direzione!=null)
				if(direzione == direzioneBloccata)
					risultato.append(" " + direzione + " (bloccata)");
				else
					risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.getAttrezzi()) {
			if(attrezzo != null)
				risultato.append(attrezzo.toString()+" ");
		}
		risultato.append("\n L'attrezzo per sbloccare la stanza " + direzioneBloccata +
				" è: "+ attrezzoRichiesto);
		return risultato.toString();
	}
	
	@Override 
	public String getDescrizione() {
		return this.toString();
	}


}
