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
		System.out.println(s);
		return s;
//2\nTEKST\n1\nOle Olsen\n23-10\n0\nen tekst\nBILDE\n2\nOline Olsen\n24-10\n0\net bilde\nhttp://www.picture.com/oo.jpg\n

		
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}