package Figury;

public abstract class Figura {

	protected String nazwa;
	
	
	public Figura() {
		this.nazwa = "";
	}
	public Figura(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public String toString() {
		return "Figura o nazwie: " + nazwa;
	}
	
	public String getNazwa() {
		return this.nazwa;
	}
	public abstract double Obwod();
	
	public abstract double Pole();
}
