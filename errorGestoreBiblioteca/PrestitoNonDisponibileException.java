package errorGestoreBiblioteca;

public class PrestitoNonDisponibileException extends Exception {
	public PrestitoNonDisponibileException(String messaggio) {
		super(messaggio);
	}
}
