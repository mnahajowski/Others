package Osoby;
import java.util.Random;
public class Pracownik extends Osoba{
	
	private String s;
	protected int pensja;
	private int stawka;
	protected int [] t = new int[7];
	
	public Pracownik() {
		super("0");
		this.s = "p1";
		this.stawka = 100;
		this.pensja = 2000;
		wypelnij();
	}
	
	public Pracownik(String pesel, String s, int pensja, int stawka) {
		super(pesel);
		this.s = s;
		this.stawka = stawka;
		this.pensja = pensja;
		wypelnij();
	}
	
	public void wypelnij() {
		Random gen = new Random();
		for(int i = 0; i < t.length; i++) {
			t[i] = gen.nextInt(4);
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
		return "Pracownik: " + this.pesel + "[stanowisko="+this.s + ", pensja"+ this.Pensja() + "\n";
	}
	
	public boolean jestPortierem() {
		if(this.s == "portier")
			return true;
		else
			return false;
	}
	public void wyswietlNadgodziny() {
		int suma = 0;
		for(int i = 0; i < this.t.length; i++) {
			suma += this.t[i];
		}
		System.out.println(suma);
	}
}
