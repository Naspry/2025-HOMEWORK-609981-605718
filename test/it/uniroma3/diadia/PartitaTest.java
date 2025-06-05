package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Labirinto;

class PartitaTest {
	
	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IOConsole io;

	@BeforeEach
	void setUp() {
	    this.labirinto = new Labirinto();
	    this.io = new IOConsole();
	    this.partita = new Partita(io, labirinto);
	    this.giocatore = partita.getGiocatore();
	}

	
	@Test
	void testIsFinitaWin() {
		// Imposta la stanza corrente in quella finale (simulando una vittoria)
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertTrue(partita.isFinita(), "Il gioco dovrebbe essere finito quando il giocatore è nella stanza finale");
	}
	
	@Test
	void testIsFinitaOutOfCFU() {
		// Imposta CFU a 0 (simulando che il giocatore finisca le mosse)
		giocatore.setCfu(0);
		assertTrue(partita.isFinita(), "Il gioco dovrebbe essere finito quando i CFU sono 0");
	}
	
	@Test
	void testSetFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita(), "Il gioco dovrebbe essere finito dopo aver chiamato setFinita()");
	}
}
