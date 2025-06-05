package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ConfigurazioniIniziali;

/**
 * Classe Giocatore 
 * 
 * @author Alfredo e Nazar
 * @version 0.0.2.a
 */

public class Giocatore {
	
	private int cfu;
	private Borsa borsa;

	public Giocatore() { 
		this.cfu = 20;
	    this.borsa = new Borsa(ConfigurazioniIniziali.getPesoMax());
	}
	
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */


	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return this.borsa;
	}
}
