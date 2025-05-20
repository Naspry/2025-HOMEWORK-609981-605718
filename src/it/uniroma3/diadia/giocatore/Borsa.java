package it.uniroma3.diadia.giocatore;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe Borsa - un giocatore ha a disposizione
 * una borsa con la quale può raccogliere attrezzi
 * sparsi lungo il labirinto
 * 
 * @author Alfredo e Nazar
 * @see Giocatore, Attrezzi
 * @version 0.0.2.a
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private int pesoMax;

	private List<Attrezzo> attrezzi;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo == null) return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
	
		return this.attrezzi.add(attrezzo);
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a: attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}
	
	public int getPeso() {
		int peso = 0;
		for(Attrezzo a: attrezzi) {
			peso += a.getPeso();
		}
		return peso;
	}
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	public boolean isFull() {
		return this.getPeso() >= this.pesoMax;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(Attrezzo attrezzo) {
		
		Iterator<Attrezzo> it = attrezzi.iterator();
		
		while(it.hasNext()) {
			Attrezzo a = it.next();
			if(a.equals(attrezzo)) {
				it.remove();
				return a;
			}
		}
		
		return null;
		
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		Iterator<Attrezzo> it = attrezzi.iterator();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			while(it.hasNext()) {
				s.append(it.next().toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}