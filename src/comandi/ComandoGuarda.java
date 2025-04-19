package comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	private IOConsole io;
	
	public ComandoGuarda(IOConsole io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Possiedi " + partita.getGiocatore().getCfu() + " cfu");
		return;
	}

	@Override
	public void setParametro(String parametro) {
	
	}

}
