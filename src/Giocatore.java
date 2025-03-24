
public class Giocatore {
	static final private int CFU_INIZIALI = 21;
	private int cfu;
	
	private Labirinto labirinto;
	
	private Borsa borsa;

	public Giocatore(Labirinto labirinto) {
		creaGiocatore();
		this.borsa = new Borsa();
		this.labirinto = labirinto;
	}

	public boolean prendi(String attrezzo) {
		Stanza stanzaCorrente = labirinto.getStanzaCorrente();
		if(!borsa.isFull()) {
			if(stanzaCorrente.hasAttrezzo(attrezzo)) {
				Attrezzo att = stanzaCorrente.getAttrezzo(attrezzo);
				if(borsa.getPeso() + att.getPeso() < borsa.getPesoMax()) {
					borsa.addAttrezzo(att);
					stanzaCorrente.removeAttrezzo(stanzaCorrente.getAttrezzo(attrezzo));
					return true;
				}	
			}
		}
		//bisogna mettere tutte le else cosi stampa piu chiaramente quale è il problema
		//es: -1 (se hai la borsa piena) -2 (se il peso è maxato) -3 (se non cè l'item)
		return false;
	}
	
	public boolean posa(String attrezzo) {
		Stanza stanzaCorrente = labirinto.getStanzaCorrente();
		if(!borsa.isEmpty() && stanzaCorrente.getNumeroAttrezzi() < 10) {
			Attrezzo att = borsa.getAttrezzo(attrezzo);
			stanzaCorrente.addAttrezzo(att);
			borsa.removeAttrezzo(att);
			return true;
		}
		return false;
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

	public Borsa getBorsa() {
		return this.borsa;
	}
}
