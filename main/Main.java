package main;
import java.time.LocalDate;
import model.*;
import service.*;



public class Main {
	public static void main(String[] args) {
		String str = "I promessi Sposi";
		Utente u2 = new Utente("Gianpiercarlo", "De Pascalis");
		LocalDate d =  LocalDate.now();
		Libro l1 = new Libro("Stephan King","983-234421-46760","It");
		Libro l2 = new Libro("Stephan King","983-234421-46760","It");
		Libro l3 = new Libro("Alessandro Manzoni", "144-3423400-230", "I promessi Sposi");
		Prestito p = new Prestito(new Utente("Massimo", "Troisi"),l1, d);
		GestoreCatalogo catalogo = new GestoreCatalogo();
		catalogo.aggiungiLibro(l3);
		System.out.println(catalogo.dimCatalogo());
		Libro libroCercato = catalogo.cercaLibroPerTitolo(str);
		System.out.println(libroCercato.getAutore());
		
	
	}
	

}
