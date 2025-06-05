package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
public class AbstractPersonaggioTest {
	
	IO io = new IOConsole();
	Partita partita;
	Stanza stanza;
	@BeforeEach
	public void setUp() {
		partita = new Partita(io);
		stanza = new Stanza("test chamber");
		partita.getLabirinto().setStanzaCorrente(stanza);
	}
	
	@Test
	public void CaneTest() {
	    Cane c = new Cane("doggo", "ciao sono bau"); 
	    stanza.setPersonaggio(c);
	    
	    partita.getGiocatore().setCfu(20);
	    c.interagisci(partita);
	    assertEquals(19, partita.getGiocatore().getCfu());
	}
	
	@Test
	public void MagoTest() {
		Attrezzo palleDiMetallo = new Attrezzo("Palle di Metallo", 10);
		Mago m = new Mago("maggie", "ciao sono mago", palleDiMetallo);
		stanza.setPersonaggio(m);
		
		assertFalse(stanza.getAttrezzo(palleDiMetallo.getNome()) != null);
		m.interagisci(partita);
		assertTrue(stanza.getAttrezzo(palleDiMetallo.getNome()) != null);
	}
	
	
	@Test
	public void StregaTest() {
		Attrezzo palleDiMetallo = new Attrezzo("Palle di Metallo", 10);
		Mago m = new Mago("maggie", "ciao sono mago", palleDiMetallo);
		stanza.setPersonaggio(m);
		
		assertFalse(stanza.getAttrezzo(palleDiMetallo.getNome()) != null);
		m.interagisci(partita);
		assertTrue(stanza.getAttrezzo(palleDiMetallo.getNome()) != null);
	}
	
	@Test
	public void StregaTest_spostataInStanzaConPiuAttrezzi_dopoSaluto() {
	    // Creo le stanze adiacenti
	    Stanza nord = new Stanza("nord");
	    Stanza sud = new Stanza("sud");

	    // Aggiungo attrezzi (nord ne ha 2, sud ne ha 1)
	    nord.addAttrezzo(new Attrezzo("osso", 1));
	    nord.addAttrezzo(new Attrezzo("chiave", 1));
	    sud.addAttrezzo(new Attrezzo("pietra", 2));

	    // Collego le stanze alla stanza corrente
	    stanza.impostaStanzaAdiacente(Direzione.NORD, nord);
	    stanza.impostaStanzaAdiacente(Direzione.SUD, sud);

	    // Creo la strega e la saluto prima di interagire
	    Strega s = new Strega("streghetta", "sono una strega");
	    stanza.setPersonaggio(s);
	    s.saluta();  // questo cambia il comportamento

	    // Interazione
	    s.interagisci(partita);

	    // Verifica che il giocatore sia stato spostato nella stanza con più attrezzi (nord)
	    assertEquals("nord", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void StregaTest_spostataInStanzaConMenoAttrezzi_senzaSaluto() {
	    // Creo le stanze adiacenti
	    Stanza nord = new Stanza("nord");
	    Stanza sud = new Stanza("sud");

	    // nord ha 2 attrezzi, sud ne ha 0
	    nord.addAttrezzo(new Attrezzo("osso", 1));
	    nord.addAttrezzo(new Attrezzo("chiave", 1));
	    // sud resta vuota

	    // Collego le stanze alla stanza corrente
	    stanza.impostaStanzaAdiacente(Direzione.NORD, nord);
	    stanza.impostaStanzaAdiacente(Direzione.SUD, sud);

	    // Creo la strega SENZA salutarla
	    Strega s = new Strega("streghetta", "sono una strega");
	    stanza.setPersonaggio(s);

	    // Interazione
	    s.interagisci(partita);

	    // Verifica che il giocatore sia stato spostato nella stanza con meno attrezzi (sud)
	    assertEquals("sud", partita.getStanzaCorrente().getNome());
	}



}
