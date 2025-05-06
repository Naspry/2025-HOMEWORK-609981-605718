package it.uniroma3.diadia.giocatore;





/**
 * Classe Giocatore 
 * 
 * @author Alfredo e Nazar
 * @version 0.0.2.a
 */

public class Giocatore {
	static final private int CFU_INIZIALI = 21;
	private int cfu;
	private Borsa borsa;

	public Giocatore() { 
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
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
