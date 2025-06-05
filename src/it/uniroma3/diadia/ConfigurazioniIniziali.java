package it.uniroma3.diadia;

import java.io.IOException;
import java.util.Properties;


public final class ConfigurazioniIniziali {

	private static final String DIADIA_PROPERTIES = "diadia.properties";
	private static final String PESO_MAX = "pesoMax";
	private static final String CFU = "cfu";
	private static Properties prop = null;
	
	public static int getCFU() {
		if(prop == null)
			carica();
		String cfuString = prop.getProperty(CFU);
	    System.out.println("🔍 Valore letto da file properties (cfu) = " + cfuString);
		return Integer.parseInt(prop.getProperty(CFU));
	}
	
	public static int getPesoMax() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(PESO_MAX));
	}

	private static void carica() {
	    prop = new Properties();
	    try {
	        var stream = ConfigurazioniIniziali.class.getClassLoader().getResourceAsStream(DIADIA_PROPERTIES);
	        if (stream == null) {
	            System.err.println("❌ File diadia.properties NON trovato");
	            return;
	        } else {
	            System.out.println("✅ File diadia.properties trovato");
	        }
	        prop.load(stream);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
