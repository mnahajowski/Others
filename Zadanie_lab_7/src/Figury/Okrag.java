package Figury;
import java.lang.Math;
public class Okrag extends Figura{

	private int r;
	private int x;
	private int y;
	
	public Okrag() {
		super("Bazowy");
		this.r = 1;
		this.x = 0;
		this.y = 0;
	}
	
	public Okrag(String nazwa, int r, int x, int y) {
		super(nazwa);
		this.r = r;
		this.x = x;
		this.y = y;
	}
	
	public double Obwod() {
		return 2* Math.PI * this.r;
	}
	
	public double Pole() {
		return r * r *  Math.PI;
	}
	
	public String toString() {
		return "Okrag: " + this.getNazwa() + "[r=" + this.r + ", x=" + this.x + ", y=" + this.y + "]";
	}
	
	public boolean nalezy(int a, int b) {
		double odleglosc = Math.sqrt((a-this.x) * (a - this.x) + (b - this.y) * (b - this.y));
		if(odleglosc > this.r)
			return false;
		else
			return true;
	}
}
