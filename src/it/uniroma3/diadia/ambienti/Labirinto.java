package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe che crea il labirinto iniziale della partita,
 * aggiungendo in ogni stanza i relativi attrezzi.
 * Setta lo spawn del giocatore e la stanza vincente.
 *
 *
 * @author  Alfredo e Nazar
 * @see partita        
 * @version 0.0.2.a
 */

public class Labirinto {
	Stanza stanzaIniziale;
	Stanza stanzaFinale;
	Stanza stanzaCorrente;
	
	public Labirinto() {
		creaStanze();
	}
	
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	
	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}
	
	public void setStanzaFinale(Stanza stanzaFinale) {
		this.stanzaFinale = stanzaFinale;
	}
	
	private void creaStanze() {
	    /* crea gli attrezzi */
	    Attrezzo lanterna = new Attrezzo("lanterna", 3); // torcia per N2
	    Attrezzo osso = new Attrezzo("osso", 1);
	    Attrezzo chiave = new Attrezzo("chiave", 1);

	    /* crea stanze del labirinto */
	    Stanza atrio = new Stanza("Atrio");
	    Stanza aulaN10 = new Stanza("Aula N10");
	    Stanza aulaN11 = new Stanza("Aula N11");
	    Stanza laboratorio = new Stanza("Laboratorio Campus");
	    StanzaBuia N2 = new StanzaBuia("N2", "lanterna");
	    StanzaBloccata bagno = new StanzaBloccata("Bagno", "nord", "chiave");
	    StanzaMagica N9 = new StanzaMagica("N9");
	    StanzaBuia N3 = new StanzaBuia("N3", null); // sempre buia
	    Stanza biblioteca = new Stanza("Biblioteca");

	    /* collega le stanze */
	    atrio.impostaStanzaAdiacente("nord", laboratorio);

	    laboratorio.impostaStanzaAdiacente("sud", atrio);
	    laboratorio.impostaStanzaAdiacente("est", aulaN11);
	    laboratorio.impostaStanzaAdiacente("nord", N2);

	    aulaN11.impostaStanzaAdiacente("ovest", laboratorio);
	    aulaN11.impostaStanzaAdiacente("est", aulaN10);

	    aulaN10.impostaStanzaAdiacente("ovest", aulaN11);

	    N2.impostaStanzaAdiacente("sud", laboratorio);
	    N2.impostaStanzaAdiacente("nord", bagno);

	    bagno.impostaStanzaAdiacente("sud", N2);
	    bagno.impostaStanzaAdiacente("nord", N9);

	    N9.impostaStanzaAdiacente("sud", bagno);
	    N9.impostaStanzaAdiacente("nord", biblioteca);
	    N9.impostaStanzaAdiacente("est", N3);

	    N3.impostaStanzaAdiacente("ovest", N9);

	    biblioteca.impostaStanzaAdiacente("sud", N9);

	    /* pone gli attrezzi nelle stanze */
	    atrio.addAttrezzo(osso);
	    aulaN10.addAttrezzo(lanterna);
	    aulaN11.addAttrezzo(chiave);

	    /* definizione inizio/fine gioco */
	    this.stanzaIniziale = atrio;
	    this.stanzaCorrente = this.stanzaIniziale;
	    this.stanzaFinale = biblioteca;
	}

}
