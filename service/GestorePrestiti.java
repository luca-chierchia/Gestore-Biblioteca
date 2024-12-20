package service;
import model.*;
import java.time.*;
import java.util.*;
import service.*;
import errorGestoreBiblioteca.*;

// classe per gestire l'aggiunta o la rimozioni dei prestiti.
public class GestorePrestiti {
	private List<Prestito> prestiti ;
	
	public GestorePrestiti() {
		this.prestiti = new ArrayList<>();
	}
	
	public int prestitiAttuali() {
		return this.prestiti.size();
	}
	
	public void registraPrestito(Utente user, Libro l, GestoreUtenti gu, GestoreCatalogo gc)
			throws LibroNonTrovatoException,PrestitoNonDisponibileException {
		
		// Verifico se il libro è presente a catalogo
		Libro libroTrovato = gc.cercaLibroPerTitolo(l.getTitolo());
		if( libroTrovato == null )
			throw new LibroNonTrovatoException("Libro non presente in catalogo");
		
		// Se è presente a catalogo, verifico che sia disponibile al prestito.
		if( libroTrovato != null &&  libroTrovato.getStato() == false) {
			throw new PrestitoNonDisponibileException("Libro non disponibile per il prestito");
		}
		
		// Verifico se l'utente è registrato per poter successivamente associare all'utente il prestito.
		Utente u = gu.cercaPerNome(user.getNome());
		if( u == null)
			System.out.println("Utente non trovato");
		else {
			Prestito p = new Prestito(u,l,LocalDate.now());
			this.prestiti.add(p);
			libroTrovato.cambiaStato();
		}
	} 
	
	public void registraRestituzione() {
		
		//TODO
		
	}
	
}
