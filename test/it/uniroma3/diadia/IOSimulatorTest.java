package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	
	IO io;
	Partita partita;
	
	@BeforeEach
	void setup() {
		io = new IOSimulator();
		partita = new Partita(io);	
	}
	
	@Test
	void testVittoria() {
		
		String vittoria[] = {
				"vai nord", "vai ovest", "prendi chiave", "vai ovest", 
				"prendi lanterna", "vai est", "vai nord", "posa lanterna",
				"vai nord", "posa chiave", "vai nord", "vai nord"
		};
		
		for(int i = 0; i < vittoria.length; i++) {
			io.mostraMessaggio(vittoria[i]);
			io.leggiRiga();
		}
		assertTrue(partita.isVinta());
		assertTrue(partita.isFinita());
	}

}
