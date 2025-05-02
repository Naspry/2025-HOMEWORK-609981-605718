package it.uniroma3.diadia;

public class IOSimulator implements IO {

	private String[] comandi;
	int i = 0;
	
	final String ANSI_RESET = "\u001B[0m";
	final String ANSI_GREEN = "\u001B[32m";

	public IOSimulator(String[] comandi) {
		this.comandi = comandi;
	}


	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio + '\n');
		
	
	}

	@Override
	public String leggiRiga() {
		if(i<comandi.length) {
			this.mostraMessaggio(ANSI_GREEN + comandi[i] + ANSI_RESET);
			return this.comandi[i++];
		}
		return null;

	}
}
