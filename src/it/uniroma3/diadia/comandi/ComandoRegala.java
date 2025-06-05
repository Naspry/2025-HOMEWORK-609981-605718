package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{
	String parametro;
	private static final String COSA_REGALO = "Cosa vuoi regalare?";

	public ComandoRegala(IO io) {
		setIO(io);
	}



	@Override
	public void esegui(Partita partita) {
		this.parametro = getParametro();
		if(this.parametro==null) getIO().mostraMessaggio(COSA_REGALO);
		else {
			Attrezzo attrezzoDaRegalare = partita.getGiocatore().getBorsa().getAttrezzo(parametro);
			if(attrezzoDaRegalare!=null) {
				getIO().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(partita.getGiocatore().getBorsa().removeAttrezzo(attrezzoDaRegalare), partita));
			}
		}
	}

}
