
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

	public Partita(){
		
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore(labirinto);
		this.finita = false;
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	
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
		return this.labirinto.getStanzaCorrente() == this.labirinto.getStanzaFinale();
	}

}
