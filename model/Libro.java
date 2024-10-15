package model;

public class Libro {
	public String isbn, autore, titolo;  
	public boolean stato; // TRUE = disponibile , FALSE = in prestito.
	
	public Libro(String is, String a, String t ) {
		this.autore = a;
		this.isbn = is;
		this.titolo = t;
		this.stato = true;	
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public boolean getStato() {
		return stato;
	}

	public void cambiaStato() {
		if(!this.stato)
			this.stato = true;
		else
			this.stato = false;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * 17 + this.autore.hashCode();
		result = 31 * 17 + this.titolo.hashCode();
		result = 31 * 17 + this.isbn.hashCode();
		return result;
		
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		Libro libro = (Libro) obj;
		return this.getAutore().equals(libro.getAutore()) && this.getTitolo().equals(libro.getTitolo()) && this.getIsbn().equals(libro.getIsbn()); // basterebbe l'ISBN in quanto è una chiave univoca per riconoscere il libro
	}

	@Override
	public String toString() {
		String disp;
		if(this.stato)
			disp = "disponibile";
		else
			disp = "in prestito";
		return "Titolo: " + this.getTitolo() + "\n" +
			   "Autore: " + this.getAutore() + "\n" +
			   "ISBN: " + this.getIsbn() + "\n" +
			   "Disponibilità: " + disp + "\n" ;
	}
	
	
	
}
