package model;
import java.time.*;

public class Prestito {
	private Utente u;
	private Libro l;
	private LocalDate dataPrestito, dataRestituzione;
	
	public Prestito(Utente u, Libro l, LocalDate d) {
		this.u = u;
		this.l = l;
		this.dataPrestito = d.now();
		this.dataRestituzione = LocalDate.now().plusWeeks(2);
		this.l.cambiaStato();
	}

	public Utente getU() {
		return u;
	}

	public void setU(Utente u) {
		this.u = u;
	}

	public Libro getL() {
		return l;
	}

	public void setL(Libro l) {
		this.l = l;
	}

	public LocalDate getDataPrestito() {
		return dataPrestito;
	}

	public void setDataPrestito(LocalDate dataPrestito) {
		this.dataPrestito = dataPrestito;
	}

	public LocalDate getDataRestituzione() {
		return dataRestituzione;
	}

	public void setDataRestituzione(LocalDate dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}
	
	public void rinnovoPrestito() {
		//TODO
	}
	
	public String toString() {
		return  this.u.toString() + "\n" +
				"Ha in prestito il seguente Libro: " + this.l.getTitolo() + "\n" +
				"Prestato il:" + this.getDataPrestito() + "\n" +
				"Restituzione prevista per:_" + this.getDataRestituzione();		
	}
	
}
