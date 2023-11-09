package model;

public class Casella {
	private int numero;
	private String colore;
	private String immagine;
	public Casella(int numero, String colore, String immagine) {
		this.numero = numero;
		this.colore = colore;
		this.immagine = immagine;
	}
	public Casella() {
		
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

}
