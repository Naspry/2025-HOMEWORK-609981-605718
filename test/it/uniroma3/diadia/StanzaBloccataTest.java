package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	Stanza stanzaBloccata;
	Stanza stanzaEffettivamenteBloccata;
	Stanza stanza2;
	Attrezzo chiave;

	@BeforeEach
	void setUp() {
		stanzaBloccata = new StanzaBloccata("stanzaBloccata", "est", "chiave");
		stanzaEffettivamenteBloccata = new Stanza("stanzaQualsiasi");
		stanzaBloccata.impostaStanzaAdiacente("est", stanzaEffettivamenteBloccata);
		stanzaBloccata.impostaStanzaAdiacente("nord", stanza2);
	}
	@Test
	void testStampaDirezioni() {
		assertEquals("est", stanzaBloccata.getDirezioni()[0]);
		assertEquals("nord", stanzaBloccata.getDirezioni()[1]);
	}
	@Test
	void testAccessoSenzaAttrezzo() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("est"));
	}
	
	@Test
	void testAccessoConAttrezzo() {
		chiave = new Attrezzo("chiave", 2);
		stanzaBloccata.addAttrezzo(chiave);
		assertEquals(stanzaEffettivamenteBloccata, stanzaBloccata.getStanzaAdiacente("est"));
	}
}
