package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	Innlegg[] innleggtabell;
	int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innlegg.erLik(innleggtabell[i])) {
				return true;
			}

		} 
		return false;
	}

	public boolean ledigPlass() {
		return innleggtabell.length > nesteledig;
	}

	public boolean leggTil(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++) {
			if (innlegg.getId() == innleggtabell[i].getId())
				return false;
		}
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}

	public String toString() {
		String s = "";
		s = s + (nesteledig) + "\n";
		for (int i = 0; i < nesteledig; i++) {
			
			s = s + innleggtabell[i].toString();
		}
		return s;
		
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] newTab = new Innlegg[innleggtabell.length * 2];
		
		for (int i = 0; i < nesteledig; i++) {
			newTab[i] = innleggtabell[i];
		}
		innleggtabell = newTab; 
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		for (int i = 0; i < nesteledig; i++) {
			if (innlegg.getId() == innleggtabell[i].getId())
				return false;
		}
		
		if (!ledigPlass()) {
			utvid();
		}
		
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}

	public boolean slett(Innlegg innlegg) {
		
			for (int i = 0; i < nesteledig; i++) {
				if (innleggtabell[i].getId() == innlegg.getId()) {
					innleggtabell[i] = innleggtabell[nesteledig-1];
					innleggtabell[nesteledig-1] = null;
					nesteledig--;
					return true;	
				}
			}
		return false;
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}