package Osoby;

import java.util.Random;

public class Dyrektor extends Pracownik{

	private int premia;
	
	public Dyrektor() {
		super("0", "p1", 100, 200);
		int [] t = new int[7];
		Random gen = new Random();
		for(int i = 0; i < t.length; i++) {
			t[i] = gen.nextInt(4);
		}
		this.premia = 500;
	}
	
	public Dyrektor(String pesel, String s, int pensja, int stawka, int premia) {
		super(pesel, s, pensja, stawka);
		this.premia = premia;
	}
	
	public double Pensja() {
		return this.pensja + this.premia;
	}
	
	public String toString() {
		return "Jest to dyrektor " + super.toString();
	}
}
