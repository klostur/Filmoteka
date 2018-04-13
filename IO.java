package oop.filmoteka;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class IO {
	private static String putanjaFilmovi = "filmovi";

	public static void snimiFilmoveGodiste(List<Film> filmovi, int pocetak, int kraj) throws IOException {
		PrintWriter output = null;
		int counter = 1;
		try {
			output = new PrintWriter(new FileWriter(putanjaFilmovi));
			output.println("Filmovi izdati od "+pocetak + " do "+ kraj+":");
			for (int i = 0; i < filmovi.size(); i++) {
				if ((filmovi.get(i).getGodinaIzdanja() >= pocetak) & (filmovi.get(i).getGodinaIzdanja() <= kraj)) {
				output.println(counter+ ". "+filmovi.get(i).getNaziv());
				counter++;
				}
			}
		} finally {
			if (output != null) 
				output.close();
		}
	}
}
