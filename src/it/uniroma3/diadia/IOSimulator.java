package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] comandi;
	int i = 0;

	public IOSimulator(String[] comandi) {
		this.comandi = comandi;
	}


	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
		System.out.println("----------------------------------------");
	
	}

	@Override
	public String leggiRiga() {
		if(i<comandi.length) {
			return this.comandi[i++];
		}
		return null;

	}
}
