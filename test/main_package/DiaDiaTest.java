package main_package;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;

import org.junit.jupiter.api.BeforeEach;

class DiaDiaTest {
	
	private Partita partita;
	private Giocatore giocatore;
	private IOConsole io;

	@BeforeEach
	void setUp() {
		this.partita = new Partita(io);
		this.io = io;
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
