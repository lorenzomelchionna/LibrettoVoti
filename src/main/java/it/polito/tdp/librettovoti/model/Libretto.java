package it.polito.tdp.librettovoti.model;

import java.util.*;

public class Libretto {
	
	private List<Voto> Voti;
	private Map<String, Voto> MappaVoti;
	
	public Libretto() {
		
		this.Voti = new ArrayList<>();
		this.MappaVoti = new HashMap<>();
		
	}
	
	public void add(Voto v) {
		
		this.Voti.add(v);
		this.MappaVoti.put(v.getNome(), v);
		
	}
	
	public Libretto votiUguali(int punteggio) {
		
		Libretto Risultato = new Libretto();
		
		for(Voto v : Voti)
			if(v.getVoto() == punteggio)
				Risultato.add(v);
		
		return Risultato;
		
	}
	
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome.
	 * Se il corso non esiste, restituisce null.
	 * 
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		return this.MappaVoti.get(nomeCorso);
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame e la stessa votazione.
	 * 
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		
		Voto Trovato = this.MappaVoti.get(v.getNome());
		
		if(Trovato == null)
			return false;
		
		if(Trovato.getVoto() == v.getVoto())
			return true;
		else 
			return false;
		
	}
	
	/**
	 * Verifica se nel libretto c'è un voto con lo stesso esame ma votazione diversa.
	 * 
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		
		Voto Trovato = this.MappaVoti.get(v.getNome());
		
		if(Trovato == null)
			return false;
		
		if(Trovato.getVoto() != v.getVoto())
			return true;
		else 
			return false;		
		
	}
	
	public String toString() {
		
		String s = "";
		
		for(Voto v : Voti)
			s += v.toString()+"\n";
		
		return s;
		
	}
	
}
