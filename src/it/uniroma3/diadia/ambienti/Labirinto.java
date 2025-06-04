package it.uniroma3.diadia.ambienti;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe che crea il labirinto iniziale della partita,
 * aggiungendo in ogni stanza i relativi attrezzi.
 * Setta lo spawn del giocatore e la stanza vincente.
 *
 * Mappa del labirinto
 
							+---------------------+
                            | Biblioteca (Finale) |
                            +----------^----------+
                                       | Nord / Sud
                                       |
    +------------+     Ovest / Est   +---------------------+
    | N3 (Buia)  | <---------------- | N9 (Magica)         |
    +------------+                   +----------^----------+
                                                | Nord / Sud  (Uscita NORD da Bagno è BLOCCATA senza 'chiave')
                                                |
                                          +---------------------+
                                          | Bagno               |
                                          +--------^------------+
                                                   | Nord / Sud
                                                   |
                                    +--------------------------------+
                                    | N2 (Buia - richiede 'lanterna') |
                                    +--------------^------------------+
                                                   | Nord / Sud
                                                   |
    +----------------+    Ovest / Est   +---------------------+     Ovest / Est   +---------------------+
    | Aula N10       | <-------------- | Aula N11            | <---------------- | Laboratorio Campus  |
    | (lanterna - 3) |                 | (chiave - 1)        |                   |                     |
    +----------------+                 +---------------------+                   +----------^----------+
                                                                                            | Nord / Sud
                                                                                            |
                                                                                      +---------------------+
                                                                                      | Atrio (Iniziale)    |
                                                                                      | (osso - 1)          |
                                                                                      +---------------------+
	 
 *
 * @author  Alfredo e Nazar
 * @see partita        
 * @version 0.0.2.a
 */

public class Labirinto {
	Stanza stanzaIniziale;
	Stanza stanzaFinale;
	Stanza stanzaCorrente;
	Set<Stanza> stanze;
	
	public Labirinto() {
		this.stanze = new HashSet<>();
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

	    
	    stanze.add(atrio);
	    stanze.add(aulaN10);
	    stanze.add(aulaN11);
	    stanze.add(laboratorio);
	    stanze.add(N2);
	    stanze.add(bagno);
	    stanze.add(N9);
	    stanze.add(N3);
	    stanze.add(biblioteca);
	    //...

	    /* collega le stanze */
	    atrio.impostaStanzaAdiacente("nord", laboratorio);

	    laboratorio.impostaStanzaAdiacente("sud", atrio);
	    laboratorio.impostaStanzaAdiacente("ovest", aulaN11);

	    aulaN11.impostaStanzaAdiacente("est", laboratorio);
	    aulaN11.impostaStanzaAdiacente("ovest", aulaN10);
	    aulaN11.impostaStanzaAdiacente("nord", N2);

	    aulaN10.impostaStanzaAdiacente("est", aulaN11);

	    N2.impostaStanzaAdiacente("sud", aulaN11);
	    N2.impostaStanzaAdiacente("nord", bagno);

	    bagno.impostaStanzaAdiacente("sud", N2);
	    bagno.impostaStanzaAdiacente("nord", N9);

	    N9.impostaStanzaAdiacente("sud", bagno);
	    N9.impostaStanzaAdiacente("nord", biblioteca);
	    N9.impostaStanzaAdiacente("ovest", N3);

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
	
	public Set<Stanza> getStanze(){
		return stanze;
	}
	
}
