package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Giocatore giocatore;
	
	private Labirinto labirinto;
	private boolean finita;
	
	//private IOConsole io;

	public Partita(IO io){
		this.giocatore = new Giocatore();
		this.labirinto = new Labirinto();
		this.finita = false;
	}
	public Partita(IO io, Labirinto labirinto){
	    this.giocatore = new Giocatore();
	    this.labirinto = labirinto;
	    this.finita = false;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public void setLabirinto(Labirinto lab) {
		this.labirinto = lab;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	public boolean isFinita() {
		return finita || isVinta() || (giocatore.getCfu() == 0);
	}

	public void setFinita() {
		this.finita = true;
	} 

	public boolean isVinta() {
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
	}

	public Stanza getStanzaCorrente() {
		return this.labirinto.getStanzaCorrente();
	}

}
