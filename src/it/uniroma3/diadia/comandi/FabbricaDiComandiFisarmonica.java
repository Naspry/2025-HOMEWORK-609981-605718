package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
    private IO io;

    public FabbricaDiComandiFisarmonica(IO io) {
        this.io = io;
    }

    @Override
    public Comando costruisciComando(String istruzione) {
        String[] parole = istruzione.trim().split("\\s+");
        String nomeComando = (parole.length > 0) ? parole[0] : null;
        String parametro = null;
        if (parole.length > 1) {
            parametro = String.join(" ", java.util.Arrays.copyOfRange(parole, 1, parole.length));
        }

        Comando comando = null;

        if (nomeComando == null || nomeComando.isEmpty()) {
            return new ComandoNonValido(io);
        }

        String nomeClasse = "it.uniroma3.diadia.comandi.Comando" +
                Character.toUpperCase(nomeComando.charAt(0)) +
                nomeComando.substring(1);

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
