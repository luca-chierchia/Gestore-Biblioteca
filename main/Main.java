package main;
import service.*;
import model.Libro;
import model.Utente;
import model.Prestito;
import errorGestoreBiblioteca.LibroNonTrovatoException;
import errorGestoreBiblioteca.PrestitoNonDisponibileException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creazione dei gestori
        GestorePrestiti gestorePrestiti = new GestorePrestiti();
        GestoreUtenti gestoreUtenti = new GestoreUtenti();
        GestoreCatalogo gestoreCatalogo = new GestoreCatalogo();

        // Creazione di un utente e di alcuni libri
        Utente utente1 = new Utente("Mario", "Rossi");
        Libro libro1 = new Libro("J.R.R. Tolkien", "12345", "Il Signore degli Anelli");
        Libro libro2 = new Libro("J.K. Rowling", "67890", "Harry Potter e la Pietra Filosofale");

        // Aggiunta dell'utente al gestore degli utenti e dei libri al catalogo
        gestoreUtenti.aggiungiUtente(utente1);
        gestoreCatalogo.aggiungiLibro(libro1);
        gestoreCatalogo.aggiungiLibro(libro2);

        // Visualizzazione della dimensione degli utenti e del catalogo
        System.out.println("Numero di utenti registrati: " + gestoreUtenti.dimGestoreUtenti());
        System.out.println("Numero di libri nel catalogo: " + gestoreCatalogo.dimCatalogo());

        // Prova a registrare un prestito per il primo libro
        try {
            gestorePrestiti.registraPrestito(utente1, libro1, gestoreUtenti, gestoreCatalogo);
            System.out.println("Prestito registrato con successo per il libro: " + libro1.getTitolo());
        } catch (LibroNonTrovatoException e) {
            System.out.println(e.getMessage());
        } catch (PrestitoNonDisponibileException e) {
            System.out.println(e.getMessage());
        }

        // Verifica che il libro sia stato impostato come "in prestito"
        System.out.println(libro1.toString());

        // Prova a registrare nuovamente il prestito dello stesso libro (dovrebbe fallire)
        try {
            gestorePrestiti.registraPrestito(utente1, libro1, gestoreUtenti, gestoreCatalogo);
        } catch (LibroNonTrovatoException e) {
            System.out.println(e.getMessage());
        } catch (PrestitoNonDisponibileException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        // Visualizzazione del numero di prestiti attuali
        System.out.println("Numero di prestiti attuali: " + gestorePrestiti.prestitiAttuali());
    }
}
