package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {

    private Borsa borsa;
    private Attrezzo martello;
    private Attrezzo pinza;
    private Attrezzo osso;
    private Attrezzo spada;

    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        martello = new Attrezzo("martello", 3);
        pinza = new Attrezzo("pinza", 1);
        osso = new Attrezzo("osso", 2);
        spada = new Attrezzo("spada", 3);
        borsa.addAttrezzo(martello);
        borsa.addAttrezzo(pinza);
        borsa.addAttrezzo(osso);
        borsa.addAttrezzo(spada);
    }

    @Test
    void testGetContenutoOrdinatoPerPeso() {
        List<Attrezzo> ordinati = borsa.getContenutoOrdinatoPerPeso();
        assertEquals(List.of(pinza, osso, martello, spada), ordinati);
    }

    @Test
    void testGetContenutoOrdinatoPerNome() {
        SortedSet<Attrezzo> ordinati = borsa.getContenutoOrdinatoPerNome();
        List<Attrezzo> ordinatiLista = new ArrayList<>(ordinati);
        assertEquals(List.of(martello, osso, pinza, spada), ordinatiLista);
    }

    @Test
    void testGetContenutoRaggruppatoPerPeso() {
        Map<Integer, Set<Attrezzo>> mappa = borsa.getContenutoRaggruppatoPerPeso();
        
        assertEquals(2, mappa.get(3).size()); // martello e spada
        assertTrue(mappa.get(3).contains(martello));
        assertTrue(mappa.get(3).contains(spada));
        
        assertEquals(Set.of(osso), mappa.get(2));
        assertEquals(Set.of(pinza), mappa.get(1));
    }
}
