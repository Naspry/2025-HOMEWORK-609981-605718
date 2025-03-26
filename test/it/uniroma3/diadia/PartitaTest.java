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

	
	@BeforeEach
	void setUp() {
		partita = new Partita();  // Initialize a new game
		labirinto = partita.getLabirinto(); // Get the labyrinth
		giocatore = partita.getGiocatore(); // Get the player
	}

	@Test
	void testIsFinitaWin() {
		// Set the current room to the final room (simulating a win)
		labirinto.setStanzaCorrente(labirinto.getStanzaFinale());
		assertTrue(partita.isFinita(), "Il gioco dovrebbe essere finito quando il giocatore è nella stanza finale");
	}
	
	
	@Test
	void testIsFinitaOutOfCFU() {
		// Set CFU to 0 (simulating the player losing all life points)
		giocatore.setCfu(0);
		assertTrue(partita.isFinita(), "Il gioco dovrebbe essere finito quando i CFU sono 0");
	}
	
	@Test
	void testSetFinita() {
		// Manually end the game
		partita.setFinita();
		assertTrue(partita.isFinita(), "Il gioco dovrebbe essere finito dopo aver chiamato setFinita()");
	}
}
