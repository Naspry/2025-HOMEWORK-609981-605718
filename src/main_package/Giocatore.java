package main_package;

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

	public boolean prendi(String nomeAttrezzo) {
		Stanza stanzaCorrente = labirinto.getStanzaCorrente();
		if(!borsa.isFull()) {
			if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
				Attrezzo att = stanzaCorrente.getAttrezzo(nomeAttrezzo);
				if(borsa.getPeso() + att.getPeso() < borsa.getPesoMax()) {
					borsa.addAttrezzo(att);
					stanzaCorrente.removeAttrezzo(stanzaCorrente.getAttrezzo(nomeAttrezzo));
					return true;
				}//else return -2;
			}//else return -3;
		}//else return -1;
		//es: -1 (se hai la borsa piena) -2 (se il peso è maxato) -3 (se non cè l'item)
		return false;
	}

	public boolean posa(String nomeAttrezzo) {
		Stanza stanzaCorrente = labirinto.getStanzaCorrente();
		if(borsa.hasAttrezzo(nomeAttrezzo)) {
			if(!borsa.isEmpty() ) {
				if(stanzaCorrente.getNumeroAttrezzi() < 10) {
					Attrezzo att = borsa.removeAttrezzo(borsa.getAttrezzo(nomeAttrezzo));
					if(att != null) {
						stanzaCorrente.addAttrezzo(att);
						return true;
					}
				}
			}
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
