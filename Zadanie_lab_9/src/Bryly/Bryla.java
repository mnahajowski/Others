package Bryly;
import java.io.Serializable;
public abstract class Bryla implements Serializable, Comparable<Bryla>{
	private String kolor;
	protected int h;
	
	public Bryla(String k, int h) {
		this.kolor = k;
		this.h = h;
	}
	@Override
	public String toString() {
		return "Kolor: " + getKolor() + ", Wysokosc h= " + getH();
	}

	public String getKolor() {
		return kolor;
	}

	public void setKolor(String kolor) {
		this.kolor = kolor;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	
	public int compareTo(Bryla br) {
		return (this.toString()).compareTo(br.toString());
	}
	
	public abstract double Objetosc();
}
