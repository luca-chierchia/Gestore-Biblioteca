package main;
import java.time.LocalDate;
import java.time.*;
import model.*;



public class Main {
	public static void main(String[] args) {
		Utente u2 = new Utente("Gianpiercarlo", "De Pascalis");
		LocalDate d =  LocalDate.now();
		Libro l1 = new Libro("Stephan King","983-234421-46760","It");
		Libro l2 = new Libro("Stephan King","983-234421-46760","It");
		Libro l3 = new Libro("Alessandro Manzoni", "144-3423400-230", "I promessi Sposi");
		Prestito p = new Prestito(new Utente("Massimo", "Troisi"),l1, d);
		
		System.out.println(p);
		
	
	}
	

}
