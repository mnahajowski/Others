package Bryly;

import java.io.Serializable;

public class Stozek extends Bryla{
	private int r;
	
	public Stozek(String k, int h, int r) {
		super(k,h);
		this.r = r;
	}
	@Override
	public String toString() {
		return super.toString() + " promien r = " + this.r + " Objetosc = " + Objetosc();
	}
	
	public double Objetosc() {
		return Math.PI * this.r * this.r * h /3;
	}
}
 