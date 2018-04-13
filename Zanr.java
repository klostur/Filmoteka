package oop.filmoteka;

public class Zanr {
	private String identifikator;
	private String naziv;
	
	public Zanr(String identifikator, String naziv) {
		super();
		this.identifikator = identifikator;
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getIdentifikator() {
		return identifikator;
	}
	
	
}
