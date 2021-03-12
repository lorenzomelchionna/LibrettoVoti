package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> Voti;
	
	public Libretto() {
		this.Voti = new ArrayList<>();
	}
	
	public void add(Voto v) {
		this.Voti.add(v);
	}
	
	public Libretto votiUguali(int punteggio) {
		
		Libretto Risultato = new Libretto();
		
		for(Voto v : Voti)
			if(v.getVoto() == punteggio)
				Risultato.add(v);
		
		return Risultato;
		
	}
	
	public String toString() {
		
		String s = "";
		
		for(Voto v : Voti)
			s += v.toString()+"\n";
		
		return s;
		
	}
	
}
