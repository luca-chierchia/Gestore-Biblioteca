package service;
import model.*;
import java.util.*;


public class GestoreUtenti {
	private List<Utente> utenti;
	
	public GestoreUtenti() {
		this.utenti = new ArrayList<>();
	}
	
	public int dimGestoreUtenti() {
		return this.utenti.size();
	}
	
	public void aggiungiUtente(Utente u) {
		if(!this.utenti.contains(u))
			this.utenti.add(u);
		else
			System.out.println("Utente già esistente");
	}
	
	public Utente cercaPerNome(String n) {
		Iterator<Utente> it = this.utenti.iterator();
		while(it.hasNext()) {
			Utente u = it.next();
			if(u.getNome().equals(n))
				return u;	
		}
		return null;
		
	}
}
