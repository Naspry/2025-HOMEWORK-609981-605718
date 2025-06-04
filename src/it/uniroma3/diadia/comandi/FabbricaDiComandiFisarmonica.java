package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
    private IO io;

    public FabbricaDiComandiFisarmonica(IO io) {
        this.io = io;
    }

    @Override
    public Comando costruisciComando(String istruzione) {
        String[] parole = istruzione.split(" ");
        String nomeComando = null;
        String parametro = null;

        Comando comando = null;
    
        if (parole[0]!=null) nomeComando = parole[0];
        if (parole.length!=1 && parole[1]!=null) parametro = parole[1];
        
        
        if (nomeComando == null || nomeComando.isEmpty()) {
            return new ComandoNonValido(io);
        }
        	

        String nomeClasse = "it.uniroma3.diadia.comandi.Comando" +
                Character.toUpperCase(nomeComando.charAt(0)) +
                nomeComando.substring(1); //controlla anche per 0
       
        try {
            Class<?> classeComando = Class.forName(nomeClasse);
            comando = (Comando) classeComando.getDeclaredConstructor(IO.class).newInstance(io);
        } catch (Exception e) {
            comando = new ComandoNonValido(io);
        }
        
        comando.setParametro(parametro);
        return comando;
    }

}
