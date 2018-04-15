package oop.filmoteka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Filmoteka {
	static List<Film> filmovi = new ArrayList<>();
	static List<Zanr> zanrovi = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		zanrovi.add(new Zanr("1", "Akcija"));
		zanrovi.add(new Zanr("2", "Romansa"));

		filmovi.add(new Film(String.valueOf(filmovi.size() + 1), "Mrtav Tetreb", 1999, zanrovi.get(0)));
		filmovi.add(new Film(String.valueOf(filmovi.size() + 1), "Kola ko u vola", 2000, zanrovi.get(1)));
		filmovi.add(new Film(String.valueOf(filmovi.size() + 1), "Paja Patak u Dubrovniku", 2003, zanrovi.get(0)));

		String unos = "";
		do {
			meni();
			unos = unesi();
			switch (unos) {
			case "1":
				unosNovogFilma();
				break;
			case "2":
				prikazSvihFilmova();
				break;
			case "3":
				pretragaFilmovaPoZanru();
				break;
			case "4":
				snimiFilmovePoGodistu();
				break;
			default:
				break;
			}

		} while (!unos.equals("x"));
	}

	private static void snimiFilmovePoGodistu() throws IOException {
		System.out.println("Pocetna godina:");
		int pocetak = Integer.parseInt(unesi());
		System.out.println("Krajnja godina:");
		int kraj = Integer.parseInt(unesi());
		IO.snimiFilmoveGodiste(filmovi, pocetak, kraj);
	}

	private static void pretragaFilmovaPoZanru() {
		prikaziZanrove();
		String unos = unesi();
		String zanr = zanrovi.get(Integer.parseInt(unos) - 1).getNaziv();
		for (int i = 0; i < filmovi.size(); i++) {
			if (zanr.equals(filmovi.get(i).getZanr().getNaziv())) {
				filmovi.get(i).prikazFilma();
			}
		}
	}

	private static void prikazSvihFilmova() {
		if (filmovi.size() == 0) {
			System.out.println("Nema unetih filmova.");
			return;
		}
		for (int i = 0; i < filmovi.size(); i++) {
			filmovi.get(i).prikazFilma();
		}
		System.out.println();
	}
	private static Film unosNovogFilmaBezZanra() {
		System.out.println("Unesite naziv filma:");
		String naziv = unesi();
		System.out.println("Unesite godinu izdanja:");
		int godinaIzdanja = Integer.parseInt(unesi());
		Film film = new Film(String.valueOf(filmovi.size() + 1), naziv, godinaIzdanja);
		return film;
	}

	private static void unosNovogFilma() {
		Film film = unosNovogFilmaBezZanra();
		System.out.println("1)Izaberi postojeci zanr 2)Unesi novi zanr");
		System.out.println("---------------------------");
		
		String unos = unesi();
		switch (unos) {
		case "1":
			film.setZanr(unesiPostojeciZanr());
			break;
		case "2":
			film.setZanr(unosNovogZanra());
			break;
		default:
			break;
		}
		
		filmovi.add(film);

	}

	private static Zanr unesiPostojeciZanr() {
		Zanr zanr = null;
		String unosZanr = "";
		boolean done = false;
		do {
			try {
				prikaziZanrove();
				unosZanr = unesi();
				zanr = zanrovi.get(Integer.parseInt(unosZanr) - 1);
				done = true;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Izaberite jedan od ponudjenih odgovora.");
			} catch (NumberFormatException e) {
				System.out.println("Izaberite jedan on ponudjenih odgovora.");
			}
		} while (!done);
		return zanr;
	}

	private static void prikaziZanrove() {
		if (zanrovi.size() == 0) {
			System.out.println("Nema unetih zanrova");
			return;
		}
		for (int i = 0; i < zanrovi.size(); i++) {
			System.out.println(i + 1 + ") " + zanrovi.get(i).getNaziv());
		}
	}

	private static Zanr unosNovogZanra() {
		System.out.println("Unesite naziv zanra");
		String naziv = unesi();
		Zanr zanr = new Zanr(String.valueOf(zanrovi.size() + 1), naziv);
		zanrovi.add(zanr);
		return zanr;
	}

	static String unesi() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
			s = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	static void meni() {
		System.out.println("*******************************");
		System.out.println("Dobrodosli u Davidovu filmoteku");
		System.out.println("1. Unesi novi film");
		System.out.println("2. Prikazi sve filmove");
		System.out.println("3. Pretraga filmova po zanru");
		System.out.println("4. Snimanje naziva filmova u fajl u odredjenom vremenskom periodu");
		System.out.println("x. Izlaz");
	}
}
