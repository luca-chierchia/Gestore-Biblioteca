package errorGestoreBiblioteca;

public class LibroNonTrovatoException extends Exception{
	public LibroNonTrovatoException(String messaggio) {
		super(messaggio);
	}
}
