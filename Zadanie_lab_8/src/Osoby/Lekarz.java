package Osoby;

import java.util.Random;

public class Lekarz extends Osoba{
	private String s;
	private int pensja;
	private int stawka;
	private int [] t = new int[5];
	
	public Lekarz() {
		super("0");
		this.s = "p1";
		this.stawka = 100;
		this.pensja = 2000;
		wypelnij();
	}
	
	public Lekarz(String pesel, String s, int pensja, int stawka) {
		super(pesel);
		this.s = s;
		this.stawka = stawka;
		this.pensja = pensja;
		wypelnij();
	}
	
	public void wypelnij() {
		Random gen = new Random();
		for(int i = 0; i < t.length; i++) {
			t[i] = 20 + gen.nextInt(10);
		}
	}
	
	public double Pensja() {
		int suma = 0;
		for(int i = 0; i < this.t.length; i++) {
			suma += this.t[i];
		}
		return this.pensja + this.stawka * suma;
	}
	
	public String toString() {
		return "Lekarz: " + this.pesel + "[stanowisko="+this.s + ", pensja"+ this.Pensja() + "\n";
	}
	
	public int wyswietlLiczbePacjentow() {
		int suma = 0;
		for(int i = 0; i < this.t.length; i++) {
			suma += this.t[i];
		}
		return suma;
	}
	
}