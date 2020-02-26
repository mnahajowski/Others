package Figury;

public class Prostokat extends Figura{
	private int a;
	private int b;
	
	public Prostokat() {
		super("Bazowy");
		this.a = 1;
		this.b = 1;
	}
	
	public Prostokat(String nazwa, int a, int b) {
		super(nazwa);
		this.a = a;
		this.b = b;
	}
	
	public double Obwod() {
		return 2*a+2*b;
	}
	
	public double Pole() {
		return a*b;
	}
	
	public String toString() {
		return "Prostokat: " + this.getNazwa() + "[a=" + this.a + ", b=" + this.b + "]";
	}
	
	public boolean jestKwadratem() {
		if(this.a == this.b)
			return true;
		else
			return false;
	}
	
}
