package model;

public class Utente {
	private String nome,cognome;
	private static int idCounter = 1000;
	private int id;
	
	public Utente(String n, String c) {
		this.nome = n;
		this.cognome = c;
		this.id = this.idCounter++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int result = 17;
		return result = 31 * 17 + this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		Utente user = (Utente) obj;
		return this.getNome().equals(user.getNome()) && this.getCognome().equals(user.getCognome());
	}


	@Override
	public String toString() {
		return "Utente: " + this.getNome() + " " + this.getCognome() + "\nID: " + this.getId();
	}
	

}
