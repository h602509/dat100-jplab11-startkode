package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		Blogg blogg = null;

		try {

			File fil = new File(mappe + "/" + filnavn);
			Scanner leser = new Scanner(fil);

			
			int antallInnlegg = Integer.parseInt(leser.nextLine());
			blogg = new Blogg(antallInnlegg);
			
			String typeInnlegg;

			for (int i = 0; i < antallInnlegg; i++) {

				typeInnlegg = leser.nextLine();
				int id = Integer.parseInt(leser.nextLine());
				String bruker = leser.nextLine();
				String dato = leser.nextLine();
				int likes = Integer.parseInt(leser.nextLine());
				String tekst = leser.nextLine();

				if (typeInnlegg.equals(TEKST)) {

					Tekst t = new Tekst(id, bruker, dato, likes, tekst);
					blogg.leggTil(t);

				}

				if (typeInnlegg.equals(BILDE)) {
					String url = leser.nextLine();
					Bilde b = new Bilde(id, bruker, dato, likes, tekst, url);
					blogg.leggTil(b);
				}
				
			}

			leser.close();
			return blogg;

		} catch (FileNotFoundException e) {
			System.out.println("finner ikke filen");
			return null;

		} catch (Exception f) {
			System.out.println("her ble det krøll");
			return null;
		}
	}
}
