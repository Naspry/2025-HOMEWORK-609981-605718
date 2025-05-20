package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class StanzaMagicaTest {
	StanzaMagica stanzaMagicaSoglia, stanzaMagicaVuota; 
	Attrezzo corda, spada, pennarello, sale, pepe;
	
	@BeforeEach
	void setUp() {
	corda = new Attrezzo("corda", 1);
	spada = new Attrezzo("spada", 2);
	pennarello = new Attrezzo("pennarello", 1);
	pepe = new Attrezzo("pepe", 1);
	stanzaMagicaSoglia = new StanzaMagica("Stanza magica soglia");
	stanzaMagicaSoglia.addAttrezzo(spada);
	stanzaMagicaSoglia.addAttrezzo(pennarello);
	stanzaMagicaSoglia.addAttrezzo(sale);
	
	stanzaMagicaVuota = new StanzaMagica("Stanza magica vuota");
	}
	

	@Test
	void testComportamentoMagico() {
		stanzaMagicaSoglia.addAttrezzo(pepe);
		assertTrue(stanzaMagicaSoglia.hasAttrezzo("epep"), "deve invertire 'pepe'");
		assertEquals(2, stanzaMagicaSoglia.getAttrezzi().get(3).getPeso(),"pepe ora pesa il doppio");
		assertTrue(stanzaMagicaSoglia.getNumeroAttrezzi() == 4, "deve incrementare in numero degli attrezzi");
		stanzaMagicaVuota.addAttrezzo(corda);
		assertFalse(stanzaMagicaVuota.hasAttrezzo("adroc"), "la soglia non è stata superata" );
	}

	@Test
	void testCostruttore() {
		StanzaMagica stanzaMagica2 = new StanzaMagica("Stanza Magica 2");
		assertTrue(stanzaMagica2.getSogliaMagica()== stanzaMagica2.getSogliaMagicaDefault());
		StanzaMagica stanzaMagica3 = new StanzaMagica("Stanza Magica 3", 4);
		assertTrue(stanzaMagica3.getSogliaMagica() == 4);
	}
	
}
