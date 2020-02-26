package Bryly;

import java.io.Serializable;

public class Ostroslup extends Bryla{
	private int a;
	private int b;
	private boolean prawidlowy;
	
	public Ostroslup(String k, int h, int a, int b) {
		super(k,h);
		this.a = a;
		this.b = b;
		if(a == b)
			this.prawidlowy = true;
		else
			this.prawidlowy = false;
	}
	@Override
	public String toString() {
		return super.toString() + "Bok a = " + getA() + ", Bok b = " + getB() + ", Prawidlowy = " + isPrawidlowy() + ", Objetosc + " + Objetosc();
	}
	
	public double Objetosc()  {
		return a * b * h / 3;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public boolean isPrawidlowy() {
		return prawidlowy;
	}

	public void setPrawidlowy(boolean prawidlowy) {
		this.prawidlowy = prawidlowy;
	}
}
