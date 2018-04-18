package oop.filmoteka;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class IO {
	private static String putanjaFilmoviGodina = "filmoviOdDo";
	private static String putanjaFilmovi = "filmovi";

	public static void snimiFilmoveGodiste(List<Film> filmovi) throws IOException {
		System.out.println("Pocetna godina:");
		int pocetak = Integer.parseInt(Filmoteka.unesi());
		System.out.println("Krajnja godina:");
		int kraj = Integer.parseInt(Filmoteka.unesi());
		PrintWriter output = null;
		int counter = 1;
		try {
			output = new PrintWriter(new FileWriter(putanjaFilmoviGodina));
			output.println("Filmovi izdati od " + pocetak + " do " + kraj + ":");
			for (int i = 0; i < filmovi.size(); i++) {
				if ((filmovi.get(i).getGodinaIzdanja() >= pocetak) & (filmovi.get(i).getGodinaIzdanja() <= kraj)) {
					output.println(counter + ". " + filmovi.get(i).getNaziv());
					counter++;
				}
			}
		} finally {
			if (output != null)
				output.close();
		}
	}

	public static void snimiFilmoveUFajl(List<Film> filmovi) {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileWriter(putanjaFilmovi));
			for (Film film : filmovi) {
				output.println(film2String(film));
			}
		} catch (IOException e) {
			System.out.println("IO Ex occured when saving movies");
			e.printStackTrace();
		} finally {
			if (output != null)
				output.close();
		}
	}

	public static ArrayList<Film> ucitajFilmoveIzFajla() throws IOException {
		BufferedReader inputStream = null;
		ArrayList<Film> filmovi = null;
		try {
			inputStream = new BufferedReader(new FileReader(putanjaFilmovi));
			filmovi = new ArrayList<>();
			String l;
			while ((l = inputStream.readLine()) != null) {
				filmovi.add(string2Film(l));
			}
			return filmovi;
		} finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	private static String film2String(Film film) {
		return film.getIdentifikator() + "," + film.getNaziv() + "," + film.getGodinaIzdanja() + ","
				+ film.getZanr().getIdentifikator() + "," + film.getZanr().getNaziv();
	}

	private static Film string2Film(String red) {
		String[] s = red.split(",");
		Film film = new Film(s[0], s[1], Integer.parseInt(s[2]), new Zanr(s[3], s[4]));
		return film;
	}

}
