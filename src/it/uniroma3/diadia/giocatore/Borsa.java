package it.uniroma3.diadia.giocatore;

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
	
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==attrezzi.length)
			return false;
		int i = 0;
		while(i < attrezzi.length) {
			if(attrezzi[i] == null) {
				attrezzi[i] = attrezzo;
				this.numeroAttrezzi++;
				return true;
				
			}	
			i++;
		}
		return false;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.attrezzi.length; i++)
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.attrezzi.length; i++) {
			if(this.attrezzi[i] != null)
				peso += this.attrezzi[i].getPeso();
		}
		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean isFull() {
		return this.numeroAttrezzi == 10;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(Attrezzo attrezzo) { 
		if (attrezzo == null) {
			return attrezzo;
		}

		for (int i = 0; i < this.attrezzi.length; i++) {
			if (this.attrezzi[i] != null && attrezzi[i] == attrezzo){
				this.attrezzi[i] = null; 
				this.numeroAttrezzi -= 1;
				return attrezzo; 
			} 
		}

		return attrezzo; 
	}
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.attrezzi.length; i++) {
				if(attrezzi[i] != null)
					s.append(attrezzi[i].toString()+" ");
			}	
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}