package it.uniroma3.diadia.ambienti;

import java.util.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

    private Labirinto labirinto;
    private Stanza stanzaCorrente; // Ultima stanza aggiunta

    public LabirintoBuilder() {
        this.labirinto = new Labirinto();
    }

    public LabirintoBuilder addStanzaIniziale(String nome) {
        Stanza s = new Stanza(nome);
        this.labirinto.setStanzaCorrente(s);
        this.labirinto.getStanze().add(s); 
        this.stanzaCorrente = s;
        return this;
    }


    public LabirintoBuilder addStanzaVincente(String nome) {
        Stanza s = new Stanza(nome);
        this.labirinto.setStanzaFinale(s);
        this.stanzaCorrente = s;
        return this;
    }

    public LabirintoBuilder addStanza(String nome) {
        Stanza s = new Stanza(nome);
        this.labirinto.getStanze().add(s);
        this.stanzaCorrente = s;
        return this;
    }

    public LabirintoBuilder addAttrezzo(String nome, int peso) {
        Attrezzo a = new Attrezzo(nome, peso);
        if (this.stanzaCorrente != null) {
            this.stanzaCorrente.addAttrezzo(a);
        }
        return this;
    }

    public LabirintoBuilder addAdiacenza(String da, String a, String direzione) {
        Stanza stanzaDa = trovaStanzaPerNome(da);
        if (stanzaDa == null) {
            this.addStanza(da);
            stanzaDa = trovaStanzaPerNome(da);
        }

        Stanza stanzaA = trovaStanzaPerNome(a);
        if (stanzaA == null) {
            this.addStanza(a);
            stanzaA = trovaStanzaPerNome(a);
        }

        stanzaDa.impostaStanzaAdiacente(direzione, stanzaA);
        return this;
    }

    private Stanza trovaStanzaPerNome(String nome) {
        for (Stanza s : this.labirinto.getStanze()) {
            if (s.getNome().equals(nome))
                return s;
        }
        return null;
    }


    public Labirinto getLabirinto() {
        return this.labirinto;
    }
}

