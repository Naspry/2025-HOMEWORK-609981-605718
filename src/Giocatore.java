
public class Giocatore {
	static final private int CFU_INIZIALI = 21;
	private int cfu;

	public Giocatore() {
		creaGiocatore();
	}

	public void creaGiocatore() {
		cfu = CFU_INIZIALI;
	}
	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
}
