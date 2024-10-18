package service;
import model.*;
import java.util.*;
import errorGestoreBiblioteca.*;

/*	La classe GestoreCatalogo ci permette di aggiungere,cercare e rimuovere libri al
	catalogo.
*/
public class GestoreCatalogo {
	private List<Libro> catalogo;
	private int dimensioneCatalogo = 0;
	
	public GestoreCatalogo() {
		this.catalogo = new ArrayList<Libro>();
	}
	
	public int getDimensioneCatalogo() {
		return this.dimensioneCatalogo;
	}
	
	public void aggiungiLibro(Libro l) {
		this.catalogo.add(l);
		this.dimensioneCatalogo++;
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
				this.dimensioneCatalogo--;
				return true;
			}
		}
		return false;
	}
}
