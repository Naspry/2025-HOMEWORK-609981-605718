package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.ambienti.Labirinto;
public class AbstractPersonaggioTest {
	
	IO io = new IOConsole();
	
	@BeforeEach
	public void setUp() {
	}
	
	@Test
	public void CaneTest() {
		Partita p = new Partita(io);
	}
}
