package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	IOConsole io;
	public FabbricaDiComandiFisarmonica(IOConsole io) {
		this.io = io;
	}
	@Override
	public Comando costruisciComando(String istruzione) {
		String[] parole = istruzione.split(" ");
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (parole[0]!=null) 
			nomeComando = parole[0]; // prima parola: nome del comando
		if (parole.length!=1 && parole[1]!=null) 
			parametro = parole[1]; // seconda parola: eventuale parametro
		if (nomeComando == null)
			comando = new ComandoNonValido(io);
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(io);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(io);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(io);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(io);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(io);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(io);
		else if(nomeComando.equals("borsa"))
			comando = new ComandoBorsa(io);
		else comando = new ComandoNonValido(io);
		comando.setParametro(parametro);
		return comando;
	}
}
