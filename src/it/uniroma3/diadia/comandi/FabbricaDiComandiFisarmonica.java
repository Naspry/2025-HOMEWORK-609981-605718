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
        String nomeComando = (parole.length > 0) ? parole[0] : null;
        String parametro = (parole.length > 1) ? parole[1] : null;

        Comando comando = null;

        if (nomeComando == null || nomeComando.isEmpty()) {
            return new ComandoNonValido(io);
        }

        // Costruzione del nome della classe (es. "ComandoVai")
        String nomeClasse = "it.uniroma3.diadia.comandi.Comando" +
                Character.toUpperCase(nomeComando.charAt(0)) +
                nomeComando.substring(1);

        try {
            Class<?> classeComando = Class.forName(nomeClasse);
            comando = (Comando) classeComando.getDeclaredConstructor(IO.class).newInstance(io);
        } catch (Exception e) {
            // In caso di errore (classe non trovata o altro), comando non valido
            comando = new ComandoNonValido(io);
        }

        comando.setParametro(parametro);
        return comando;
    }
}
