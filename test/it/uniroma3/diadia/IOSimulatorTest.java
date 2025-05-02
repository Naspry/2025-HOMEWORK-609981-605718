package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	
	IO io;
	DiaDia gioco;
	
	@Test
	void testVittoria() {
		String vittoria[] = {
				"vai nord", "vai ovest", "prendi chiave", "vai ovest", 
				"prendi lanterna", "vai est", "vai nord", "posa lanterna",
				"vai nord", "posa chiave", "vai nord", "vai nord"
				};
		
		io = new IOSimulator(vittoria);
		gioco = new DiaDia(io);
		gioco.gioca();
		
		assertTrue(gioco.getPartita().isVinta());
	}

}
