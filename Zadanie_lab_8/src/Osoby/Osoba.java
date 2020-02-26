package Osoby;

public abstract class Osoba {
	protected String pesel;
	protected int pensja;
	
	public Osoba() {
		this.pesel = "0";
	}
	
	public Osoba(String pesel) {
		this.pesel = pesel;
	}
	
	public String toString() {
		return "Osoba o peselu " + this.pesel;
	}
	
	public abstract double Pensja();
}
