package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	Direzione direzioneBloccata;
	String attrezzoRichiesto;

	public StanzaBloccata(String nome, Direzione direzioneBloccata, String attrezzoRichiesto) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoRichiesto  = attrezzoRichiesto;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione dir) {
		if(dir.equals(direzioneBloccata) && this.hasAttrezzo(attrezzoRichiesto))
			return super.getStanzaAdiacente(dir);
		else if(!dir.equals(direzioneBloccata))
			return super.getStanzaAdiacente(dir);
		else
			return this;
	}
	
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getNome());
		risultato.append("\nUscite: ");
		for (Direzione direzione : this.getDirezioni())
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
		risultato.append("\nL'attrezzo per sbloccare la stanza " + direzioneBloccata +
				" è: "+ attrezzoRichiesto);
		return risultato.toString();
	}
	
	@Override 
	public String getDescrizione() {
		return this.toString();
	}


}
