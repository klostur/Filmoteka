package oop.filmoteka;

public class Film {
	private String identifikator;
	private String naziv;
	private int godinaIzdanja;
	private Zanr zanr;
	
	
	public Film(String identifikator, String naziv, int godinaIzdanja) {
		super();
		this.identifikator = identifikator;
		this.naziv = naziv;
		this.godinaIzdanja = godinaIzdanja;
	}

	public Film(String identifikator, String naziv, int godinaIzdanja, Zanr zanr) {
		this.identifikator = identifikator;
		this.naziv = naziv;
		this.godinaIzdanja = godinaIzdanja;
		this.zanr = zanr;
	}

	public String getIdentifikator() {
		return identifikator;
	}

	public String getNaziv() {
		return naziv;
	}

	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public Zanr getZanr() {
		return zanr;
	}
	
	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public void prikazFilma() {
		System.out.println(naziv + " ("+godinaIzdanja+") - " 
				+ zanr.getNaziv());
	}
	
	
}
