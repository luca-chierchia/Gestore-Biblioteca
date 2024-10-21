package service;
import model.*;
import java.util.*;
import errorGestoreBiblioteca.*;

/*	La classe GestoreCatalogo ci permette di aggiungere,cercare e rimuovere libri al
	catalogo.
*/
public class GestoreCatalogo {
	private List<Libro> catalogo;
	
	
	public GestoreCatalogo() {
		this.catalogo = new ArrayList<Libro>();
	}
	
	
	public void aggiungiLibro(Libro l) {
		this.catalogo.add(l);
		
		System.out.println(l.getTitolo() + ", aggiunto.");
	}
	
	public Libro cercaLibroPerIsbn(String s) {
		Iterator<Libro> it = this.catalogo.iterator();
		while(it.hasNext()) {
			Libro libro = it.next();
			if(libro.getIsbn().equals(s))
				return libro;
		}
		return null;
				
	}
	
	public Libro cercaLibroPerTitolo(String t) {
		Iterator<Libro> it = this.catalogo.iterator();
		while(it.hasNext()) {
			Libro libro = it.next();
			if(libro.getTitolo().equals(t))
				return libro;
		}
		return null;
		
	}
	
	public boolean rimuoviLibro(String s) {
		Iterator<Libro> it = this.catalogo.iterator();
		while(it.hasNext()) {
			Libro libro = it.next();
			if(libro.getIsbn().equals(s)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public int dimCatalogo() {
		return this.catalogo.size();
	}
}
