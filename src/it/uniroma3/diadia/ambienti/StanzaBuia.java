package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	private String attrezzoNecessario;
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoNecessario = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoNecessario))
			return this.toString();
		else
			return "c'è buio pesto";
	}

	public String getAttrezzoNecessario() {
		return attrezzoNecessario;
	}

	public void setAttrezzoNecessario(String attrezzoNecessario) {
		this.attrezzoNecessario = attrezzoNecessario;
	}

}
