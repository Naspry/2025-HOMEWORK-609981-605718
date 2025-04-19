package comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	private IOConsole io;
	
	public ComandoAiuto(IOConsole io) {
		this.io = io;
	}
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Lista comandi: [aiuto, fine, vai, prendi, posa, guarda]");
		
	}

	@Override
	public void setParametro(String parametro) {
		
	}
	
}
