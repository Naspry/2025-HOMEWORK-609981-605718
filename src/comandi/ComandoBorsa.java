package comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoBorsa implements Comando {
	private IOConsole io;
	
	public ComandoBorsa(IOConsole io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		return;
	}

	@Override
	public void setParametro(String parametro) {
		

	}

}
